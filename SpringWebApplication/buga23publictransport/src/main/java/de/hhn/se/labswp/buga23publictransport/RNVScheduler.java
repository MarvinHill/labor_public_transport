package de.hhn.se.labswp.buga23publictransport;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hhn.se.labswp.buga23publictransport.persistence.StationRepo;
import de.hhn.se.labswp.buga23publictransport.rnv.RNVQuery;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeStopInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RNVScheduler {
    static final Logger logger = LoggerFactory.getLogger(RNVScheduler.class);
    @Autowired
    StationRepo stationRepo;

    // update every hour with new time stop infos
    // @Scheduled(cron = "@hourly")
    @Scheduled(fixedRate = 3600000, initialDelay = 1) // 4 minutes delay for debugging ... annoying every time after start up
    @Async
    public void updateTimeInfoIntoDatabase() throws IOException {
        logger.info("Invoking updateTimeInfoDatabase() ...");
        var stations = stationRepo.findAll();
        ObjectMapper mapper = new ObjectMapper();
        for (var station : stations) {
            var hasafId = station.getRnvID().toString();
            var timeStopInfo = RNVQuery.getStationsTimes(hasafId);

            logger.info("Updating timeStopInfo ... " + timeStopInfo + " ...");

            String timeInfoJson = mapper.writeValueAsString(timeStopInfo);
            station.setTimeInfoJSON(timeInfoJson);
        }
        stationRepo.saveAllAndFlush(stations);
    }
}

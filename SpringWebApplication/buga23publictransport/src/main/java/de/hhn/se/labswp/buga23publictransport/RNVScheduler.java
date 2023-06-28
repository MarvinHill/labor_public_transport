package de.hhn.se.labswp.buga23publictransport;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hhn.se.labswp.buga23publictransport.persistence.StationRepo;
import de.hhn.se.labswp.buga23publictransport.rnv.RNV;
import de.hhn.se.labswp.buga23publictransport.rnv.RNVQuery;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeStopInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
@EnableAsync
public class RNVScheduler {
    static final Logger logger = LoggerFactory.getLogger(RNVScheduler.class);
    @Autowired
    StationRepo stationRepo;

    // update every hour with new time stop infos
    // @Scheduled(cron = "@hourly")
    @Scheduled(fixedRate = 1000000)
    @Async
    public void updateTimeInfoIntoDatabase() throws IOException {
        logger.info("Invoking updateTimeInfoDatabase() hourly ...");
        var stations = stationRepo.findAll();
        ObjectMapper mapper = new ObjectMapper();
        for (var station : stations) {
            var hasafId = station.getRnvID().toString();
            var timeStopInfo = RNVQuery.getStationsTimes(hasafId, RNVQuery.getNow(), RNVQuery.get1HOffset());

            logger.info("Updating timeStopInfo ... " + timeStopInfo + " ...");

            String timeInfoJson = mapper.writeValueAsString(timeStopInfo);
            station.setTimeInfoJSON(timeInfoJson);
        }
        stationRepo.saveAllAndFlush(stations);
    }

    @Scheduled(cron = "@midnight") // every day starts at 00:00:00
    public void updateTimeInfoIntoDatabaseMidnight() throws IOException {
        logger.info("Invoking updateTimeInfoDatabase() at midnight ...");
        var stations = stationRepo.findAll();
        ObjectMapper mapper = new ObjectMapper();
        for (var station : stations) {
            var hasafId = station.getRnvID().toString();
            var times = RNVQuery.getAllDay();
            var timeStopInfo = RNVQuery.getStationsTimes(hasafId, times[0], times[1]);

            logger.info("Updating timeStopInfo ... " + timeStopInfo + " ...");

            String timeInfoJson = mapper.writeValueAsString(timeStopInfo);
            station.setTimeInfoJSON(timeInfoJson);
        }
        stationRepo.saveAllAndFlush(stations);
    }
}

package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Configuration
@Component
public class LoadCapacity {
    @Autowired
    ParkingCapacityRepository capacityRepo;
    private static final Logger log = LoggerFactory.getLogger(CapacityReader.class);

    @Scheduled(cron = "0 0 * * * ?")
    @Async
    public void initializeRepo() {
        String webInfo = CapacityReader.getWebInfo();
        String currentTime = LocalDateTime.now().toString();
        String currentWeekday = LocalDateTime.now().getDayOfWeek().name();

        for (int i = 0; i < 24; i++) {
            webInfo = webInfo.substring(CapacityReader.nextNGreater(webInfo, 5));

            String parkingName = "";
            for (int j = 0; webInfo.charAt(j) != ('<'); j++) {
                parkingName = parkingName.concat(webInfo.substring(j, j + 1));
            }

            webInfo = webInfo.substring(CapacityReader.nextNGreater(webInfo, 3));

            String freeParkingspaces = "";
            for (int k = 0; webInfo.charAt(k) != ('<'); k++) {
                freeParkingspaces = freeParkingspaces.concat(webInfo.substring(k, k + 1));
            }

            var capacity = new ParkingCapacity(parkingName, Integer.parseInt(freeParkingspaces), currentTime, currentWeekday);
            log.info("Saving capacity ... " + capacityRepo.save(capacity));
        }
    }
}

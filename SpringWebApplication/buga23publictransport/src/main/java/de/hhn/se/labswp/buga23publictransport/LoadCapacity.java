package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Configuration
@Component
public class LoadCapacity {
    ParkingCapacityRepository capacityRepo;

    @Bean
    CommandLineRunner initializeRepo(ParkingCapacityRepository capacityRepo) {
        this.capacityRepo = capacityRepo;
        return null;
    }

    @Bean
    @Scheduled(cron = "0 0 * * * ?")
    public void updateParkingCapacity() {
        String webInfo = CapacityReader.getWebInfo();
        String currentTime = LocalDateTime.now().toString();

        System.out.println("Funktion aufgerufen um " + currentTime);

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

            capacityRepo.save(new ParkingCapacity(parkingName, Integer.parseInt(freeParkingspaces), currentTime));
        }
    }
}

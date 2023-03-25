package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import java.time.LocalTime;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PublicTransportLineRepo lineRepo, LineScheduleEntryRepo entryRepo) {
        return args -> {
            log.info("Preloading Database Entries");
            for (int i = 0; i < 5; i++) {
                ArrayList<LineScheduleEntry> children = new ArrayList<>();
                for (int j = 0; j < 5; j++) {
                    LineScheduleEntry entry = new LineScheduleEntry(LocalTime.now(), 1, 0, "TestStation" + j);
                    children.add(entry);
                    //log.info("Preloading " +  entryRepo.save(entry));
                }
                PublicTransportLine publicTransportLine = new PublicTransportLine(0,"TestLine" + i, false, children);
                log.info("Preloading " +  lineRepo.save(publicTransportLine));
            }
        };
    }

}

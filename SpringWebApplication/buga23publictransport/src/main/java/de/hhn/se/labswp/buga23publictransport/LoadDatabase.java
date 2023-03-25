package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PublicTransportLineRepo repo, LineScheduleEntryRepo repoLine) {
        return args -> {
            var entrie1 = new LineScheduleEntry(LocalTime.of(12, 20, 0),
                    0, 0, "TestPlatz 1");
            var entrie2 =
                    new LineScheduleEntry(LocalTime.of(13, 20, 0),
                            0, 0, "TestPlatz 2");
            var entrie3 =
                    new LineScheduleEntry(LocalTime.of(14, 20, 0),
                            0, 0, "TestPlatz 3");
            var entrie4 =
                    new LineScheduleEntry(LocalTime.of(15, 20, 0),
                            0, 0, "TestPlatz 4");
            var ptl1 = new PublicTransportLine(
                    0,
                    "TestStation1",
                    false);
            ptl1.addLineScheduleEntry(entrie1);
            ptl1.addLineScheduleEntry(entrie2);
            ptl1.addLineScheduleEntry(entrie3);
            ptl1.addLineScheduleEntry(entrie4);

            log.info("Preloading " + repo.save(ptl1));
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation2", false)));
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation3", false)));
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation4", false)));
        };
    }

}

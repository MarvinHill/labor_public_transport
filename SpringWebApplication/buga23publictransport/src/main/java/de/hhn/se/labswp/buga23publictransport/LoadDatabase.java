package de.hhn.se.labswp.buga23publictransport;

import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
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
    CommandLineRunner initDatabase(PublicTransportLineRepo repo) {
        return args -> {
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation1", false, new ArrayList<>())));
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation2", false, new ArrayList<>())));

            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation3", false, new ArrayList<>())));
            log.info("Preloading " + repo.save(
                    new PublicTransportLine(0, "TestStation4", false, new ArrayList<>())));
        };
    }

}

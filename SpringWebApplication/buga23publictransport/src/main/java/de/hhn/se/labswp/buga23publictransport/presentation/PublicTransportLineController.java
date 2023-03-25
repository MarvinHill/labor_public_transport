package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.business.LineScheduleService;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PublicTransportLineController {
    @Autowired
    LineScheduleService lineScheduleServiceImpl;

    private PublicTransportLineRepo repo;
    private LineScheduleEntryRepo repo2;

    PublicTransportLineController(PublicTransportLineRepo repo, LineScheduleEntryRepo repo2) {
        this.repo2 = repo2;
        this.repo = repo;
    }

    @GetMapping("/ptl")
    Iterable<PublicTransportLine> all() {
        return repo.findAll();
    }

    @GetMapping("/lse")
    Iterable<LineScheduleEntry> all2() {
        return repo2.findAll();
    }
}

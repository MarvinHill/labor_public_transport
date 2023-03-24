package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.business.LineScheduleService;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicTransportLineController {
    @Autowired
    LineScheduleService lineScheduleServiceImpl;

    private PublicTransportLineRepo repo;

    PublicTransportLineController(PublicTransportLineRepo repo){
        this.repo = repo;
    }

    @GetMapping("/PublicTransportLines")
    Iterable<PublicTransportLine> all() {
        return repo.findAll();
    }
}

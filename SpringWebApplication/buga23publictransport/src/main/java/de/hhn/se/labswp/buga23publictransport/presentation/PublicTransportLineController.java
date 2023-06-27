package de.hhn.se.labswp.buga23publictransport.presentation;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import de.hhn.se.labswp.buga23publictransport.LoadDatabase;
import de.hhn.se.labswp.buga23publictransport.business.LineScheduleService;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntryRepo;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;

import java.util.List;
import java.util.Optional;

import org.hibernate.LazyInitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class PublicTransportLineController {
    @Autowired
    LineScheduleService lineScheduleServiceImpl;

    private PublicTransportLineRepo repo;
    private LineScheduleEntryRepo repo2;

    private static final Logger log = LoggerFactory.getLogger(PublicTransportLineController.class);

    PublicTransportLineController(PublicTransportLineRepo repo, LineScheduleEntryRepo repo2) {
        this.repo2 = repo2;
        this.repo = repo;
    }

    @CrossOrigin("*")
    @GetMapping("/ptl")
    Iterable<PublicTransportLine> all() {
        return repo.findAll();
    }

    @GetMapping("/lse")
    Iterable<LineScheduleEntry> all2() {
        return repo2.findAll();
    }

    @GetMapping("/ptl/{lineId}")
    PublicTransportLine oneLine(@PathVariable("lineId") String lineId) {
        long parsedId = Long.parseLong(lineId);
        Optional<PublicTransportLine> line = repo.findById(parsedId);
        if (line.isEmpty()) {
            return null;
        }
        return line.get();
    }

    @DeleteMapping("/ptl/{lineId}")
    ResponseEntity<?> deleteLine(@PathVariable("lineId") String lineId) {
        long parsedId = Long.parseLong(lineId);
        if (!repo.existsById(parsedId)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        repo.deleteById(parsedId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}

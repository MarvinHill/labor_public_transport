package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.business.LineScheduleService;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicTransportLineController {
  @Autowired
  LineScheduleService lineScheduleServiceImpl;

  private PublicTransportLineRepo repo;

  PublicTransportLineController(PublicTransportLineRepo repo) {
    this.repo = repo;
  }

  @GetMapping("/public-transport-line/all")
  Iterable<PublicTransportLine> all() {
    return repo.findAll();
  }

  @GetMapping("/public-transport-line/{lineId}")
  PublicTransportLine oneLine(@PathVariable("lineId") String lineId) {
      long parsedId = Long.parseLong(lineId);
      Optional<PublicTransportLine> line = repo.findById(parsedId);
      if (line.isEmpty()) {
        return null;
      }
      return line.get();

  }
}

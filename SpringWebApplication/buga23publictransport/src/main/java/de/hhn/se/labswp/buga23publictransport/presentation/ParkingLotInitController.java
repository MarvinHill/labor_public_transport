package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.persistence.ParkingLot;
import de.hhn.se.labswp.buga23publictransport.persistence.ParkingLotRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/parking")
public class ParkingLotInitController {

    ParkingLotRepository repo;

    ParkingLotInitController(ParkingLotRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/all")
    Iterable<ParkingLot> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ParkingLot> findById(@PathVariable long id) {
        return repo.findById(id);
    }

}

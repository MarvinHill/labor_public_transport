package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api/capacity")
public class ParkingCapacityController {

    ParkingCapacityRepository capacityRepo;

    ParkingCapacityController(ParkingCapacityRepository capacityRepo) {
        this.capacityRepo = capacityRepo;
    }

    @GetMapping("/all")
    Iterable<ParkingCapacity> getAllCapacity() {
        return capacityRepo.findAll();
    }

    @GetMapping("/{id}")
    Optional<ParkingCapacity> findByIdAll(@PathVariable long id) {
        return capacityRepo.findById(id);
    }

}

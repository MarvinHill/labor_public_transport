package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.persistence.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/api/parking")
public class ParkingLotInitController {

    ParkingLotRepository allRepo;
    CarParkingLotRepository carRepo;
    BikeParkingLotRepository bikeRepo;
    CampsiteParkingRepository campsiteRepo;
    CaravanParkingLotRepository caravanRepo;

    ParkingLotInitController(ParkingLotRepository allRepo, CarParkingLotRepository carRepo, BikeParkingLotRepository bikeRepo, CampsiteParkingRepository campsiteRepo, CaravanParkingLotRepository caravanRepo) {
        this.allRepo = allRepo;
        this.carRepo = carRepo;
        this.bikeRepo = bikeRepo;
        this.campsiteRepo = campsiteRepo;
        this.caravanRepo = caravanRepo;
    }

    @GetMapping("/all")
    Iterable<ParkingLot> all() {
        return allRepo.findAll();
    }

    @GetMapping("/bike/all")
    Iterable<BikeParkingLot> bikeAll() {
        return bikeRepo.findAll();
    }

    @GetMapping("/car/all")
    Iterable<CarParkingLot> carAll() {
        return carRepo.findAll();
    }

    @GetMapping("/campsite/all")
    Iterable<CampsiteParkingLot> campsiteAll() {
        return campsiteRepo.findAll();
    }

    @GetMapping("/caravan/all")
    Iterable<CaravanParkingLot> caravanAll() {
        return caravanRepo.findAll();
    }

    @GetMapping("/all/{id}")
    Optional<ParkingLot> findByIdAll(@PathVariable long id) {
        return allRepo.findById(id);
    }

}

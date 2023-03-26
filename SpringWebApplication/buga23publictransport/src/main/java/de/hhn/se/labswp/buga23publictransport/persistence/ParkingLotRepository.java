package de.hhn.se.labswp.buga23publictransport.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Integer> { }
package de.hhn.se.labswp.buga23publictransport.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaravanParkingLotRepository extends JpaRepository<CaravanParkingLot, Long> { }
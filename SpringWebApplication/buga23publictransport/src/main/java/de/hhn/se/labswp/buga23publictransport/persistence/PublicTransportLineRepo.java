package de.hhn.se.labswp.buga23publictransport.persistence;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PublicTransportLineRepo extends JpaRepository<PublicTransportLine, Long> { }

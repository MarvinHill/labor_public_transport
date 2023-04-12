package de.hhn.se.labswp.buga23publictransport.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicTransportLineRepo extends CrudRepository<PublicTransportLine, Long> {


    @Override
    @Query(value = "SELECT * from public_transport_line", nativeQuery = true)
    Iterable<PublicTransportLine> findAll();

}

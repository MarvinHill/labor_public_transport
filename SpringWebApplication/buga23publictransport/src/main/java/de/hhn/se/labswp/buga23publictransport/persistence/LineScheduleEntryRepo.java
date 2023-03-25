package de.hhn.se.labswp.buga23publictransport.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineScheduleEntryRepo extends CrudRepository<LineScheduleEntry, Long> {
}

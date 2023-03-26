package de.hhn.se.labswp.buga23publictransport.business;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import org.springframework.stereotype.Service;

public interface LineScheduleService {

    void addEntries(PublicTransportLine ptl, LineScheduleEntry toBeAddedEntry);

    void removeEntries(PublicTransportLine ptl, LineScheduleEntry toBeRemovedEntry);

    void swapEntries(PublicTransportLine ptl, LineScheduleEntry a, LineScheduleEntry b);

    void moveEntries(PublicTransportLine ptl, LineScheduleEntry a, int pos);
}

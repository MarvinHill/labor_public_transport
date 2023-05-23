package de.hhn.se.labswp.buga23publictransport.business;

import de.hhn.se.labswp.buga23publictransport.persistence.LineScheduleEntry;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLine;
import de.hhn.se.labswp.buga23publictransport.persistence.PublicTransportLineRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class LineSchedulerServiceImpl implements LineScheduleService {
    PublicTransportLineRepo ptlRepo;
    @Override
    public void addEntries(PublicTransportLine ptl, LineScheduleEntry toBeAddedEntry) {
    }

    @Override
    public void removeEntries(PublicTransportLine ptl, LineScheduleEntry toBeRemovedEntry) {
    }

    @Override
    public void swapEntries(PublicTransportLine ptl, LineScheduleEntry a, LineScheduleEntry b) {
    }

    @Override
    public void moveEntries(PublicTransportLine ptl, LineScheduleEntry a, int pos) {
    }
}

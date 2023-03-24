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
        ptl.getLineScheduleEntryArrayList().add(toBeAddedEntry);

        ptlRepo.save(ptl);
    }

    @Override
    public void removeEntries(PublicTransportLine ptl, LineScheduleEntry toBeRemovedEntry) {
        ptl.getLineScheduleEntryArrayList().remove(toBeRemovedEntry);

        ptlRepo.save(ptl);
    }

    @Override
    public void swapEntries(PublicTransportLine ptl, LineScheduleEntry a, LineScheduleEntry b) {
        var entries = ptl.getLineScheduleEntryArrayList();
        var posA = entries.indexOf(a);
        var posB = entries.indexOf(b);

        entries.remove(a);
        entries.remove(b);

        entries.add(posB, a);
        entries.add(posA, b);

        ptlRepo.save(ptl);
    }

    @Override
    public void moveEntries(PublicTransportLine ptl, LineScheduleEntry a, int pos) {
        var entries = ptl.getLineScheduleEntryArrayList();
        var currentPos = entries.indexOf(a);
        var newPos = currentPos + pos;

        entries.remove(a);
        entries.add(newPos, a);

        ptlRepo.save(ptl);
    }
}

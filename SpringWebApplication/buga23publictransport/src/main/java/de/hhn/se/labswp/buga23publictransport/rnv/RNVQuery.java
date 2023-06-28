package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeStopInfo;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@RestController
public class RNVQuery {
    @GetMapping(
            value = "/call_rnv"
    )
    public static TimeStopInfo getStationsTimes(
            @RequestParam String hasafId,
            @RequestParam String startTime,
            @RequestParam String endTime
    ) throws IOException {
        var query = new QueryBuilder(
                ResourceUtils.getFile("classpath:graphql/GetStationTimes.graphql")
        )
                .buildRawQuery()
                .replaceData(QueryBuilder.RNVStationId, hasafId)
                .replaceData(QueryBuilder.RNVStartTime, startTime)
                .replaceData(QueryBuilder.RNVEndTime, endTime)
                .replaceData("\"", "\\\"")              // transforms (") -> (\")
                .build();

        var response = RNV.callRNV(query);
        ObjectMapper mapper = new ObjectMapper();
        var tsi = mapper.readValue(response, TimeStopInfo.class);

        var timeInfos = new ArrayList<TimeStopInfo>();
        timeInfos.add(tsi);

        // page through all cursors till null is reached
        while (tsi.getCursor() != null) {
            var queryAfter = new QueryBuilder(
                    ResourceUtils.getFile("classpath:graphql/GetStationTimesWithAfter.graphql")
            )
                    .buildRawQuery()
                    .replaceData(QueryBuilder.RNVStationId, hasafId)
                    .replaceData(QueryBuilder.RNVStartTime, startTime)
                    .replaceData(QueryBuilder.RNVEndTime, endTime)
                    .replaceData(QueryBuilder.RNVCursor, tsi.getCursor())
                    .replaceData("\"", "\\\"")             // transforms (") -> (\")
                    .build();
            tsi = mapper.readValue(RNV.callRNV(queryAfter), TimeStopInfo.class);
            timeInfos.add(tsi);

            if (tsi.getCursor().equals("null")) {
                break;
            }
        }

        // merge all cursors back to one response
        TimeStopInfo finalInfo = new TimeStopInfo();
        finalInfo.setCursor(tsi.getCursor());
        finalInfo.setHasafID(tsi.getHasafID());
        for (var t : timeInfos) {
            finalInfo.getTimeInfo().addAll(t.getTimeInfo());
        }

        return finalInfo;
    }

    public static String get1HOffset() {
        var now = Instant.now();
        now = now.plus(60, ChronoUnit.MINUTES);
        return now.toString();
    }

    public static String[] getAllDay() {
        var tuple = new String[2];
        tuple[0] = Instant.now().toString();
        tuple[1] = Instant.now().plus(23, ChronoUnit.HOURS).toString();
        return tuple;
    }

    public static String getNow() {
        return Instant.now().toString();
    }
}

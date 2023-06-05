package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RNVQuery {
    @GetMapping(
            value = "/call_api"
    )
    static TimeStopInfo getStationsTimes(
            @RequestParam String hasafId,
            @RequestParam String startTime) throws IOException {
        var query = new QueryBuilder(
                ResourceUtils.getFile("classpath:graphql/GetStationTimes.graphql")
        )
                .buildRawQuery()
                .replaceData(QueryBuilder.RNVStationId, hasafId)
                .replaceData(QueryBuilder.RNVStartTime, startTime)
                .replaceData("\"", "\\\"")              // transforms " -> \"
                .build();
        var response = RNV.callRNV(query);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, TimeStopInfo.class);
    }


}

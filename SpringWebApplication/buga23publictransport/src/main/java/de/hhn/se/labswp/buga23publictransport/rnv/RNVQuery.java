package de.hhn.se.labswp.buga23publictransport.rnv;

import org.springframework.data.geo.Point;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@RestController
public class RNVQuery {
    public static String RNVStationId = "rnv_hasaf_station_id"; // hasafID of the station
    public static String RNVStartTime = "rnv_start_time"; // when is the departure time of the station


    @GetMapping(
            value = "/call_api"
    )
    static String getStationsTimes(String hasafId, String startTime) throws IOException {
        // builds the query from the prototype GetStationTimes.txt
        var prototypeBody = ResourceUtils.getFile("classpath:graphql/GetStationTimes.txt");
        StringBuilder body = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(prototypeBody))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("#")) { // dont append comments to the query
                    body.append(line);
                    body.append("\n");
                }
            }
        }
        var filledBody = body.toString().replace(RNVStationId, "2444").replace(RNVStartTime, "2023-05-30T12:27:36Z");


        // call the api to get all stops from the given hasafID
        var response = TokenAccess.callRNV(filledBody);

        return response;
    }
}

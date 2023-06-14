package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeInfo;
import de.hhn.se.labswp.buga23publictransport.rnv.persistence.TimeStopInfo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class TimeStopInfoDeserializer extends StdDeserializer<TimeStopInfo> {
    private final Set<String> SUPPORTED_LINES = Set.of(
            "7",
            "6",
            "9",
            "BL",
            "BS",
            "P+R"
    );
    private final Set<String> SUPPORTED_DESTINATIONS = Set.of(
            "Vogelstang", // for line 7 and BS, destination => Spinelli-Park in the north
            "SAP Arena S-Bf",
            "Neuostheim",
            "BUGA 23 Haupteingang", // P+R has two diffrent destinations ... with the same linegroup
            "Luisenpark (BUGA 23)" // P+R has two diffrent destinations ... with the same linegroup
    );

    // see https://www.rnv-online.de/media/rnv-online.de/Sonstige_Seiten/Kampagnen/Bundesgartenschau/Mit_der_rnv_zur_BUGA_23.pdf
    // for more information for the destinations. -> till now everything points to one direction.
    private final Map<String, String> DESTINATION_MAP_TO_BUGA = new HashMap<>();

    public TimeStopInfoDeserializer() {
        this(null);
        DESTINATION_MAP_TO_BUGA.put("7", "Vogelstang");
        DESTINATION_MAP_TO_BUGA.put("BS", "Vogelstang");
        DESTINATION_MAP_TO_BUGA.put("6", "SAP Arena S-Bf");
        DESTINATION_MAP_TO_BUGA.put("BL", "SAP Arena S-Bf");
        DESTINATION_MAP_TO_BUGA.put("9", "Neuostheim");
    }

    public TimeStopInfoDeserializer(Class<TimeStopInfo> t) {
        super(t);
    }

    @Override
    public TimeStopInfo deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        var cursor = node.get("data").get("station").get("journeys").get("cursor").asText();
        var timeStopInfo = new TimeStopInfo();
        timeStopInfo.setHasafID(node.get("data").get("station").get("hafasID").asText());
        timeStopInfo.setCursor(cursor);

        int totalCount = node.get("data").get("station").get("journeys").get("totalCount").asInt();
        timeStopInfo.setTimeInfo(new ArrayList<>(totalCount));

        var elements = node.get("data").get("station").get("journeys").get("elements").elements();

        if (!elements.hasNext()) {
            return timeStopInfo;
        }

        for (var element = elements.next(); elements.hasNext(); element = elements.next()) {
            // skips not supported lines from the json
            var lineGroup = element.get("line").get("lineGroup").get("label").asText();
            if (!SUPPORTED_LINES.contains(lineGroup)) {
                continue;
            }

            var timeInfo = new TimeInfo();
            timeInfo.lineGroup = lineGroup;

            var stops = element.get("stops").elements().next();
            timeInfo.plannedDeparture = parseISOTime(stops.get("plannedDeparture").get("isoString").asText());
            timeInfo.realtimeDeparture = parseISOTime(stops.get("realtimeDeparture").get("isoString").asText());
            timeInfo.destinationLabel = stops.get("destinationLabel").asText();

            var destination = stops.get("destinationLabel").asText();
            // skips not right destination to the buga ground
            if (!SUPPORTED_DESTINATIONS.contains(destination)) {
                continue;
            }

            // TODO: Filter right direction here
            if (DESTINATION_MAP_TO_BUGA.get(timeInfo.lineGroup) == null) {
                continue;
            }

            timeStopInfo.getTimeInfo().add(timeInfo);
        }

        return timeStopInfo;
    }

    private static String parseISOTime(String iso8601Time) {
        try {
            TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(iso8601Time);
            Instant i = Instant.from(ta);
            var date = Date.from(i);
            var sdf = new SimpleDateFormat("HH:mm:ss", Locale.GERMANY);
            return sdf.format(date);
        } catch (DateTimeParseException dtpe) {
            return null;
        }
    }
}

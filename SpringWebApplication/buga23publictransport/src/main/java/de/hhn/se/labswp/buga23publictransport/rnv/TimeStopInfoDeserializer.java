package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;

public class TimeStopInfoDeserializer extends StdDeserializer<TimeStopInfo> {

    public TimeStopInfoDeserializer() {
        this(null);
    }

    public TimeStopInfoDeserializer(Class<TimeStopInfo> t) {
        super(t);
    }

    @Override
    public TimeStopInfo deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);

        var timeStopInfo = new TimeStopInfo();
        timeStopInfo.hasafID = node.get("data").get("station").get("hafasID").asText();

        int totalCount = node.get("data").get("station").get("journeys").get("totalCount").asInt();
        timeStopInfo.timeInfo = new ArrayList<>(totalCount);

        var elements = node.get("data").get("station").get("journeys").get("elements").elements();

        for (var i = 0; i < totalCount; i++) {
            var element = elements.next();

            var timeInfo = new TimeStopInfo.TimeInfo();
            //TODO filter here not supported line groups
            timeInfo.lineGroup = element.get("line").get("lineGroup").get("label").asText();

            var stops = element.get("stops").elements().next();
            timeInfo.plannedDeparture = stops.get("plannedDeparture").get("isoString").asText();
            timeInfo.realtimeDeparture = stops.get("realtimeDeparture").get("isoString").asText();

            timeStopInfo.timeInfo.add(i, timeInfo);
        }

        return timeStopInfo;
    }
}

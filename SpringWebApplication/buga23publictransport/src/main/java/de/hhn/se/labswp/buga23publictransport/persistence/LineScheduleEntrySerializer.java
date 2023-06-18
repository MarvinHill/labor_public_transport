package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class LineScheduleEntrySerializer extends JsonSerializer<LineScheduleEntry> {
    @Override
    public void serialize(
            LineScheduleEntry value,
            JsonGenerator gen,
            SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeStringField("id", String.valueOf(value.getId()));
        gen.writeFieldName("station");
        gen.writeObject(value.getStation());

        gen.writeArrayFieldStart("publicTransportLines");
        for (var line : value.getPublicTransportLine()) {
            gen.writeStartObject();
            gen.writeStringField("id", String.valueOf(line.getId()));
            gen.writeStringField("lineDesignator", line.getLineDesignator());
            gen.writeStringField("delay", String.valueOf(line.getDelay()));
            gen.writeEndObject();
        }
        gen.writeEndArray();

        gen.writeEndObject();
    }
}

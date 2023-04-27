package de.hhn.se.labswp.buga23publictransport.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vividsolutions.jts.geom.Polygon;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;
import java.io.IOException;
import java.util.Arrays;

@JsonComponent
public class JsonSerializer extends com.fasterxml.jackson.databind.JsonSerializer<Polygon> {

    @Override
    public void serialize(Polygon polygon, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("Area", Arrays.toString((polygon.getCoordinates())));
        jsonGenerator.writeEndObject();
    }

}

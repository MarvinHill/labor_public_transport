
package de.hhn.se.labswp.buga23publictransport.persistence;

import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PolygonConverter implements AttributeConverter<Polygon, String> {
    @Override
    public String convertToDatabaseColumn(Polygon attribute) {
        return attribute.toText();
    }

    @Override
    public Polygon convertToEntityAttribute(String dbData) {
        try {
            com.vividsolutions.jts.geom.Polygon polygon = (com.vividsolutions.jts.geom.Polygon) new WKTReader().read(dbData);
            return polygon;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
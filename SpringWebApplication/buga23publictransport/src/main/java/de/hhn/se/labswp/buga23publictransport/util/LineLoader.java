package de.hhn.se.labswp.buga23publictransport.util;

import org.springframework.data.geo.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LineLoader {
    public static List<Point> loadLineFile(String path) {
        List<Point> points = new ArrayList<>();
        try(var reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var values = getTokens(line);
                double x = Double.parseDouble(values.get(0));
                double y = Double.parseDouble(values.get(1));
                points.add(new Point(x,y));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return points;
    }

    private static List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, ",");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken());
        }
        return tokens;
    }
}

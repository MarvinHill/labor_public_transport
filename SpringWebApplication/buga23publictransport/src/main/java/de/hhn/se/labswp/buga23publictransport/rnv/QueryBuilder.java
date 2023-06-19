package de.hhn.se.labswp.buga23publictransport.rnv;

import java.io.*;

public class QueryBuilder {
    public static String RNVStationId = "rnv_hasaf_station_id"; // hasafID of the station
    public static String RNVStartTime = "rnv_start_time"; // when is the departure time of the station
    public static String RNVEndTime = "rnv_end_time"; // midnight of today to get all stations
    public static String RNVCursor = "rnv_cursor"; // cursor for paging
    private String query;
    private final File queryFile;
    public QueryBuilder(File queryFile) {
        this.queryFile = queryFile;
    }
    public QueryBuilder buildRawQuery() {
        StringBuilder body = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(queryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("#")) { // dont append comments to the query
                    body.append(line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.query = body.toString();
        return this;
    }

    public QueryBuilder replaceData(String oldString, String newString) {
        query = query.replace(oldString, newString);
        return this;
    }

    public String build() {
        var query = """
                {
                  "query": "{}"
                }""";
        query = query.replace("{}", this.query);
        return query;
    }
}

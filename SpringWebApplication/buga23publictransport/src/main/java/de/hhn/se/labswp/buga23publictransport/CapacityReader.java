package de.hhn.se.labswp.buga23publictransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URL;
import java.util.Scanner;

public class CapacityReader {

    private static final Logger log = LoggerFactory.getLogger(CapacityReader.class);
    public static String getWebInfo() {
        var htmlString = "";
        try {
            URL url = new URL("https://www.parken-mannheim.de/");
            WebClient webClient = WebClient.create();
            var response = webClient.post()
                    .uri(url.toURI())
                    .accept(MediaType.TEXT_HTML)
                    .retrieve()
                    .bodyToMono(String.class);
            htmlString = response.block();
        }catch(Exception e){
            log.info("Loading information failed...");
        }

        String webInfo = htmlString.substring(88500);

        String tableName = "Aktuell freie Parkplätze:";
        while (!(webInfo.startsWith(tableName))) {
            webInfo = webInfo.substring(1);
        }
        webInfo = webInfo.substring(CapacityReader.nextNGreater(webInfo, 2));
        return webInfo;
    }
    public static int nextNGreater(String webCode, int n) {
        int cnt = 0;
        while (n > 0) {
            if(webCode.charAt(cnt) == ('>')) {
                n--;
            }
            cnt++;
        }
        return cnt;
    }
}

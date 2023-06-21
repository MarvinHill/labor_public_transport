package de.hhn.se.labswp.buga23publictransport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Scanner;

public class CapacityReader {

    private static final Logger log = LoggerFactory.getLogger(CapacityReader.class);
    public static String getWebInfo() {
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL("https://www.parken-mannheim.de/");
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
        }catch(Exception e){
            log.info("Loading information failed...");
        }
        String webInfo = sb.toString().substring(88500);

        String tableName = "AktuellfreieParkplätze:";
        while (!(webInfo.substring(0,23).equals(tableName))) {
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

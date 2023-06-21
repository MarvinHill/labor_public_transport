package de.hhn.se.labswp.buga23publictransport.rnv;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@RestController
public class RNV {
    private static final String client_api_url = "https://graphql-sandbox-dds.rnv-online.de/";
    private static final String tenantID = "87cd3c4f-1e0a-4350-889e-3969cd4616c9";
    private static final String OAuth_URL = "https://login.microsoftonline.com/tenant/oauth2/token";
    private static final String clientID = "da5cbc65-c767-46ed-87d3-f1f17650fed8";
    private static final String clientSecret = "1lo8Q~QpW0VsJXvXNyP4U-TOVYDEBQOrNlcC3cVX";
    private static final String resource = "1484212f-edce-452a-aae9-46141bae91af";

    private static int expiresIn = 0;
    private static long elapsedTimeStamp;
    private static String accessToken;
    private static final int REMAINING_REFRESH_TIME = 60; // 60 seconds before expire

    private static String currentValidAccessToken;

    public static void getAccessToken() throws Exception {
        // refresh the token if the remaining access_token time is less or equal 60 seconds
        if (expiresIn <= REMAINING_REFRESH_TIME) {
            // insert the tenantID into the url server address
            String tokenURL = OAuth_URL.replace("tenant", tenantID);

            // create header with the right credentials
            var restTemplate = new RestTemplate();
            var headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type", "client_credentials");
            map.add("client_id", clientID);
            map.add("client_secret", clientSecret);
            map.add("resource", resource);

            // send the request to the given url to obtain the access_token
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(
                    tokenURL, request, String.class);

            // obtain the information of the response body
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.getBody());
            expiresIn = Integer.parseInt(json.get("expires_in").textValue());
            accessToken = json.get("access_token").textValue();
        } else {
            // reduce the expires In
            long elapsedTime = (System.currentTimeMillis() - elapsedTimeStamp) / 1000;
            expiresIn -= elapsedTime;
        }
        elapsedTimeStamp = System.currentTimeMillis();
    }

    static public String callRNV(String graphQLQuery) throws IOException {
        try {
            getAccessToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        WebClient webClient = WebClient.create();
        var response = webClient.post()
                .uri(client_api_url)
                .headers(
                        httpHeaders -> {
                            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                            httpHeaders.set("X-REQUEST-TYPE", "GraphQL");
                            httpHeaders.set("Authorization", "Bearer " + accessToken);
                        }
                )
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(graphQLQuery))
                .retrieve()
                .bodyToMono(String.class);

        return response.block();
    }
}

package de.hhn.se.labswp.buga23publictransport;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// database is not accessible and not configurated
// if a connection to a database is possible
// configure the application.properties file right
// and remove the exclude
//
// security needs to be configurated and the default behaivior is a login screen
// if security is correctly implemented
// remove the exclude

@SpringBootApplication(
        exclude = {SecurityAutoConfiguration.class})
@EnableScheduling
@Configuration
public class Get2bugaApplication{

    public static void main(String[] args) {
        SpringApplication.run(Get2bugaApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "http://194.195.245.93:8080/buga23publictransport-2.0", "http://194.195.245.93:8080/buga23publictransport-2.0/", "http://194.195.245.93:8080", "http://194.195.245.93", "http://get2buga.de", "https://get2buga.de", "www.get2buga.de", "http://www.get2buga.de",  "https://www.get2buga.de"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
            "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
            "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
            "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}

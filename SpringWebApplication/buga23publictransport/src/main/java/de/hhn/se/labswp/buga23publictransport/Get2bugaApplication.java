package de.hhn.se.labswp.buga23publictransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// database is not accessible and not configurated
// if a connection to a database is possible
// configure the application.properties file right
// and remove the exclude
//
// security needs to be configurated and the default behaivior is a login screen
// if security is correctly implemented
// remove the exclude
@SpringBootApplication(
        exclude = {
                SecurityAutoConfiguration.class})
public class Get2bugaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Get2bugaApplication.class, args);
    }
}

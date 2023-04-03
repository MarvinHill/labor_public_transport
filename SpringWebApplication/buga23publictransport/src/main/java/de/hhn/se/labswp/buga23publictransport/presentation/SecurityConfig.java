package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.business.CustomUserDetailsManager;
import de.hhn.se.labswp.buga23publictransport.persistence.enity.User;
import de.hhn.se.labswp.buga23publictransport.persistence.enity.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import javax.sql.CommonDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception{
    http.authorizeHttpRequests()
//        .requestMatchers(HttpMethod.GET,"/").permitAll()
//        .requestMatchers(HttpMethod.GET,"/ptl").permitAll()
//        .requestMatchers(HttpMethod.GET,"/ptl/**").permitAll()
//        .requestMatchers(HttpMethod.GET).permitAll()
//        .requestMatchers(HttpMethod.POST).hasRole(UserRole.ADMIN.name())
        .anyRequest().authenticated()
        .and().httpBasic()
        .and().authenticationProvider(authenticationProvider);

    return http.build();
  }
  @Bean
  public AuthenticationManager authManager(HttpSecurity http, AuthenticationConfiguration configuration) throws Exception {
  return configuration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider provider(CustomUserDetailsManager userDetailsService,PasswordEncoder passwordEncoder){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return  daoAuthenticationProvider;
  }
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  UserDetailsManager users(CustomUserDetailsManager manager, PasswordEncoder encoder){
    User admin = new User();
    admin.setRole(UserRole.ADMIN);
    admin.setEmail("admin");
    admin.setPassword(encoder.encode("123"));
    manager.createUser(admin);
    return manager;
  }
}

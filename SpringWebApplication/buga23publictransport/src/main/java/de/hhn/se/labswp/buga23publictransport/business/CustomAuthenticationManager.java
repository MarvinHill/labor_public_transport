package de.hhn.se.labswp.buga23publictransport.business;

import de.hhn.se.labswp.buga23publictransport.persistence.enity.User;
import de.hhn.se.labswp.buga23publictransport.persistence.repository.UserDetailRepo;
import java.util.ArrayList;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager implements AuthenticationProvider {
  private UserDetailRepo repo;

  public CustomAuthenticationManager(UserDetailRepo repo) {
    this.repo = repo;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String email = authentication.getName();
    String password = authentication.getCredentials().toString();

    if (repo.existsById(email)){
      User user = (User) repo.findByEmail(email).get();
      if ( user.getPassword().equals(password) ){
        return new UsernamePasswordAuthenticationToken(
            email,password,new ArrayList<>(user.getAuthorities())
        );
      }
    }

    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}

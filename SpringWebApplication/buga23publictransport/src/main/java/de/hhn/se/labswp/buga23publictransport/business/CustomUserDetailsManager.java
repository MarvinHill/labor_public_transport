package de.hhn.se.labswp.buga23publictransport.business;

import de.hhn.se.labswp.buga23publictransport.persistence.enity.User;
import de.hhn.se.labswp.buga23publictransport.persistence.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsManager implements UserDetailsManager {
  private final UserRepo repo;


  public CustomUserDetailsManager(UserRepo repo) {
    this.repo = repo;
  }

  @Override
  public void createUser(UserDetails user) {
      repo.saveAndFlush((User)user);
  }

  @Override
  public void updateUser(UserDetails user) {
      repo.saveAndFlush((User)user);
  }

  @Override
  public void deleteUser(String username) {
    repo.deleteById(username);
  }

  @Override
  public void changePassword(String oldPassword, String newPassword) {
    // todo - implement
  }

  @Override
  public boolean userExists(String username) {
    return repo.existsById(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return repo.findByEmail(username).get();
  }
}

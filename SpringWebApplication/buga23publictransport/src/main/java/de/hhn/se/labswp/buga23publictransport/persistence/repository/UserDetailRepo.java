package de.hhn.se.labswp.buga23publictransport.persistence.repository;

import de.hhn.se.labswp.buga23publictransport.persistence.enity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepo extends JpaRepository<User, String> {
  Optional<User> findByEmail(String email);
}

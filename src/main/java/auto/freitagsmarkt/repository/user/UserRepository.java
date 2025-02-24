package auto.freitagsmarkt.repository.user;

import auto.freitagsmarkt.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByUserName(String userName);
}

package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.components.SafetyAndSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyAndSecurityRepository extends JpaRepository<SafetyAndSecurity,Long> {
}

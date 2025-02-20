package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.specs.SafetyAndSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyAndSecurityRepository extends JpaRepository<SafetyAndSecurity,Long> {
}

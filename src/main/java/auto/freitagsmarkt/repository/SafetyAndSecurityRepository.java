package auto.cc.info.repository;

import auto.cc.info.domain.exCarComponents.SafetyAndSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafetyAndSecurityRepository extends JpaRepository<SafetyAndSecurity,Long> {
}

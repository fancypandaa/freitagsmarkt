package auto.cc.info.repository;

import auto.cc.info.domain.Suspensions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuspensionsRepository extends JpaRepository<Suspensions,Long> {
}

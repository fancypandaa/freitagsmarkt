package auto.cc.info.repository;

import auto.cc.info.domain.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FeaturesRepository extends JpaRepository<Features,Long> {
}

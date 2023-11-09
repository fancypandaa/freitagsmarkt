package auto.cc.info.repository;

import auto.cc.info.domain.Features;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeaturesRepository extends JpaRepository<Features,Long> {
    Optional<Features> findById(Long id);
}

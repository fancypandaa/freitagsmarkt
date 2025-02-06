package auto.freitagsmarkt.repository;

import auto.freitagsmarkt.domain.carSpecs.DimensionsWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionsWeightRepository extends JpaRepository<DimensionsWeight,Long> {
}

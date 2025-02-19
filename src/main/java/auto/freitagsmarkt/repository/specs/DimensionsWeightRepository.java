package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.specs.DimensionsWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionsWeightRepository extends JpaRepository<DimensionsWeight,Long> {
}

package auto.cc.info.repository;

import auto.cc.info.domain.carSpecs.DimensionsWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimAndWeightRepository extends JpaRepository<DimensionsWeight,Long> {
}

package auto.cc.info.repository;

import auto.cc.info.domain.carSpecs.Brakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakesRepository extends JpaRepository<Brakes,Long> {
}

package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.carSpecs.Brakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakesRepository extends JpaRepository<Brakes,Long> {
}

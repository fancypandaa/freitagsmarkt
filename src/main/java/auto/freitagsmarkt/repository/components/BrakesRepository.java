package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.othersComponents.Brakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrakesRepository extends JpaRepository<Brakes,Long> {
}

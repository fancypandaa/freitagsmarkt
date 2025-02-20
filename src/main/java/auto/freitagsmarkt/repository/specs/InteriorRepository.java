package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.specs.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorRepository extends JpaRepository<Interior,Long> {
}

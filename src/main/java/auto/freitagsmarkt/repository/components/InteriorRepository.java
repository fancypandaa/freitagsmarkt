package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.components.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorRepository extends JpaRepository<Interior,Long> {
}

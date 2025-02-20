package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.specs.Exterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExteriorRepository extends JpaRepository<Exterior,Long> {

}

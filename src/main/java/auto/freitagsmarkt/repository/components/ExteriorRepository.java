package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.components.Exterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExteriorRepository extends JpaRepository<Exterior,Long> {

}

package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.carSpecs.Suspensions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspensionsRepository extends JpaRepository<Suspensions,Long> {
}

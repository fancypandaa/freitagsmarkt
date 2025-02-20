package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.othersComponents.Suspensions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspensionsRepository extends JpaRepository<Suspensions,Long> {
}

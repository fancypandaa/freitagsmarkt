package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.specs.Engine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EngineRepository extends JpaRepository<Engine,Long> {
    Page<Engine> findAll(Pageable pageable);

}
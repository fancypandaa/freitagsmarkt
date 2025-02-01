package auto.cc.info.repository;

import auto.cc.info.domain.carSpecs.Exterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExteriorRepository extends JpaRepository<Exterior,Long> {

}

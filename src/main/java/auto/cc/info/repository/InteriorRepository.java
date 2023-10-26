package auto.cc.info.repository;

import auto.cc.info.domain.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InteriorRepository extends JpaRepository<Interior,Long> {
}

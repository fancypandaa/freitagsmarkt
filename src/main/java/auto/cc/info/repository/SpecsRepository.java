package auto.cc.info.repository;

import auto.cc.info.domain.Specs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SpecsRepository extends JpaRepository<Specs,Long> {

}
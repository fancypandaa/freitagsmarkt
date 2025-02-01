package auto.cc.info.repository;

import auto.cc.info.domain.carSpecs.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransmissionRepository extends JpaRepository<Transmission,Long> {

}

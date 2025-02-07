package auto.freitagsmarkt.repository.specs;

import auto.freitagsmarkt.domain.carSpecs.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransmissionRepository extends JpaRepository<Transmission,Long> {

}

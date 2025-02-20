package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.othersComponents.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TransmissionRepository extends JpaRepository<Transmission,Long> {

}

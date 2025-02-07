package auto.freitagsmarkt.repository;

import auto.freitagsmarkt.domain.exCarComponents.ExteriorEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorEquipmentRepository extends JpaRepository<ExteriorEquipment,Long> {
}

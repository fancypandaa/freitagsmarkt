package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.components.ExteriorEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorEquipmentRepository extends JpaRepository<ExteriorEquipment,Long> {
}

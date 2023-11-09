package auto.cc.info.repository;

import auto.cc.info.domain.ExteriorEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorEquipmentRepository extends JpaRepository<ExteriorEquipment,Long> {
}

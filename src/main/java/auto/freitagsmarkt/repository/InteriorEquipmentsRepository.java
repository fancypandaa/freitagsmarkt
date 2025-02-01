package auto.cc.info.repository;

import auto.cc.info.domain.exCarComponents.InteriorEquipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorEquipmentsRepository extends JpaRepository<InteriorEquipments,Long> {
}

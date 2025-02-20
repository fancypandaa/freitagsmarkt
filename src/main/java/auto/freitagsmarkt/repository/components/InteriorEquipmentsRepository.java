package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.othersComponents.InteriorEquipments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorEquipmentsRepository extends JpaRepository<InteriorEquipments,Long> {
}

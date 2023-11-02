package auto.cc.info.repository;

import auto.cc.info.commands.custom.IExteriorCustom;
import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.domain.Exterior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExteriorRepository extends JpaRepository<Exterior,Long> {

    @Query(value = "SELECT chassis, COUNT(chassis) AS types from exterior group by chassis",nativeQuery = true)
    List<IExteriorCustom> getChassisTypesByGroups();
}

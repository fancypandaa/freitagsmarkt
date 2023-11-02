package auto.cc.info.repository;

import auto.cc.info.domain.Fuel;
import auto.cc.info.commands.custom.IFuelCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface FuelRepository extends JpaRepository<Fuel,Long> {
    @Query(value = "SELECT fuel_type AS fuelType, COUNT(fuel_type) AS types from fuel group by fuel_type",nativeQuery = true)
    List<IFuelCustom> getFuelTypesByGroups();
}

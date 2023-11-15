package auto.cc.info.repository;

import auto.cc.info.commands.custom.IFuelCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;
import auto.cc.info.domain.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransmissionRepository extends JpaRepository<Transmission,Long> {
    @Query(value = "SELECT transmission, COUNT(transmission) AS transmissionType from transmission group by transmission",nativeQuery = true)
    List<ITransmissionCustom> getTransmissionTypesByGroups();
}

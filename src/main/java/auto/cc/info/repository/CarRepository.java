package auto.cc.info.repository;

import auto.cc.info.commands.custom.ICarCustom;
import auto.cc.info.commands.custom.ITransmissionCustom;
import auto.cc.info.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CarRepository extends JpaRepository<Car,Long> {
    Page<Car> findAll(Pageable pageable);

    @Query(value = "SELECT city, COUNT(city) AS countCity FROM car GROUP BY city",nativeQuery = true)
    List<ICarCustom> getCarCityGroups();
}
package auto.freitagsmarkt.repository;

import auto.freitagsmarkt.domain.carSpecs.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel,Long> {

}

package auto.freitagsmarkt.repository.components;

import auto.freitagsmarkt.domain.othersComponents.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends JpaRepository<Fuel,Long> {

}

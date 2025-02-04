package auto.freitagsmarkt.repository;

import auto.freitagsmarkt.domain.carSpecs.CarBrand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    Page<CarBrand> findAll(Pageable pageable);
}
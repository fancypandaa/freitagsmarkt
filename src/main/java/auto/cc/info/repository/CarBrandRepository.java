package auto.cc.info.repository;

import auto.cc.info.domain.CarBrand;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository

public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    Page<CarBrand> findAll(Pageable pageable);
    CarBrand findByName(String name);
}
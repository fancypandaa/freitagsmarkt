package auto.cc.info.repository;

import auto.cc.info.domain.CarBrand;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandRepository extends JpaRepository<CarBrand,Long> {
    Page<CarBrand> findAll(Pageable pageable);
    CarBrand findByName(String name);
    Page<CarBrand> findBySeries(Pageable pageable,String series);
    @Query(value = "SELECT * FROM car_brand WHERE production_years <= :productionYears",nativeQuery = true)
    Page<CarBrand> findByProductionYears(Pageable pageable,int productionYears);
    @Query(value = "SELECT * FROM car_brand WHERE production_years <= :productionYears and series = :series",nativeQuery = true)
    Page<CarBrand> findByProductionYearsAndSeries(Pageable pageable,String series, int productionYears);
}
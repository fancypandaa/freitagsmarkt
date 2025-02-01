package auto.cc.info.service;

import auto.cc.info.dto.car.CarBrandDTO;
import org.springframework.data.domain.Page;
import java.util.Optional;
public interface CarBrandService {
    Page<CarBrandDTO> listCarBrands(int page, int size);
    CarBrandDTO addNewCarBrand(CarBrandDTO carBrandCommand);
    CarBrandDTO findCarBrandById(Long carBrandId);
    Page<CarBrandDTO> findByProductionYearsAndSeries(Integer page, Integer size, Optional<String> series, Optional<Integer> productionYear);
    CarBrandDTO updateCarBrand(Long carBrandId, CarBrandDTO carBrandCommand);
    void removeCarBrandById(Long carBrandId);
}

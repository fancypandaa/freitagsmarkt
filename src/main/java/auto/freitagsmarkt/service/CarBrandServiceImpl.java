package auto.cc.info.service;


import auto.cc.info.dto.car.CarBrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarBrandServiceImpl implements CarBrandService{
    @Override
    public Page<CarBrandDTO> listCarBrands(int page, int size) {
        return null;
    }

    @Override
    public CarBrandDTO addNewCarBrand(CarBrandDTO carBrandCommand) {
        return null;
    }

    @Override
    public CarBrandDTO findCarBrandById(Long carBrandId) {
        return null;
    }

    @Override
    public Page<CarBrandDTO> findByProductionYearsAndSeries(Integer page, Integer size, Optional<String> series, Optional<Integer> productionYear) {
        return null;
    }

    @Override
    public CarBrandDTO updateCarBrand(Long carBrandId, CarBrandDTO carBrandCommand) {
        return null;
    }

    @Override
    public void removeCarBrandById(Long carBrandId) {

    }
}

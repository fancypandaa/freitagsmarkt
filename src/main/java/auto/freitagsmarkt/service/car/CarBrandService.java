package auto.freitagsmarkt.service.car;

import auto.freitagsmarkt.dto.car.CarBrandDTO;
import java.util.List;
public interface CarBrandService {
    List<CarBrandDTO> listCarBrands(int page, int size);
    CarBrandDTO addNewCarBrand(CarBrandDTO carBrandDTO);
    CarBrandDTO findCarBrandById(Long carBrandId);
    CarBrandDTO updateCarBrand(Long carBrandId, CarBrandDTO carBrandDTO);
    void removeCarBrandById(Long carBrandId);
}

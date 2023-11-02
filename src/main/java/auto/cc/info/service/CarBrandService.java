package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import org.springframework.data.domain.Page;
import java.util.Optional;
public interface CarBrandService {
    Page<CarBrandCommand> listCarBrands(int page, int size);
    CarBrandCommand addNewCarBrand(CarBrandCommand carBrandCommand);
    CarBrandCommand findCarBrandById(Long carBrandId);
    Page<CarBrandCommand> findByProductionYearsAndSeries(Integer page,Integer size,Optional<String> series,Optional<Integer> productionYear);
}

package auto.cc.info.service;

import auto.cc.info.commands.CarBrandCommand;
import org.springframework.data.domain.Page;

public interface CarBrandService {
    Page<CarBrandCommand> listCarBrands(int page, int size);

    CarBrandCommand addNewCarBrand(CarBrandCommand carBrandCommand);
}

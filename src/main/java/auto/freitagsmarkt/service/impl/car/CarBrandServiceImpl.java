package auto.freitagsmarkt.service.impl.car;


import auto.freitagsmarkt.domain.car.CarBrand;
import auto.freitagsmarkt.dto.car.CarBrandDTO;
import auto.freitagsmarkt.mapper.car.CarBrandMapper;
import auto.freitagsmarkt.repository.CarBrandRepository;
import auto.freitagsmarkt.service.car.CarBrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CarBrandServiceImpl implements CarBrandService {
    private CarBrandMapper carBrandMapper;
    private CarBrandRepository carBrandRepository;

    public CarBrandServiceImpl(CarBrandMapper carBrandMapper, CarBrandRepository carBrandRepository) {
        this.carBrandMapper = carBrandMapper;
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    public List<CarBrandDTO> listCarBrands(int page, int size) {
        Page<CarBrand> carBrands = carBrandRepository.findAll(PageRequest.of(page,size));
        if(carBrands.getTotalElements()<=0){
            return Collections.EMPTY_LIST;
        }
        return carBrandMapper.toCarBrandListDTO(carBrands.getContent());
    }

    @Override
    public CarBrandDTO addNewCarBrand(CarBrandDTO carBrandDTO) {
        return Optional.ofNullable(carBrandDTO)
                .map(carBrandMapper::toCarBrand)
                .map(carBrandRepository::save)
                .map(carBrandMapper::toCarBrandDTO)
                .orElseThrow(()-> new RuntimeException("CarBrand cannot created!!"));
    }

    @Override
    public CarBrandDTO findCarBrandById(Long carBrandId) {
        return carBrandRepository.findById(carBrandId)
                .map(carBrandMapper::toCarBrandDTO)
                .orElseThrow(()-> new RuntimeException("CarBrand Not Found"));
    }

    @Override
    public CarBrandDTO updateCarBrand(Long carBrandId, CarBrandDTO carBrandDTO) {
        CarBrand carBrand = carBrandRepository.findById(carBrandId)
                .orElseThrow(()-> new RuntimeException("CarBrand not found"));
        carBrandMapper.updateCarBrandDto(carBrandDTO,carBrand);
        return carBrandMapper.toCarBrandDTO(carBrandRepository.save(carBrand));
    }

    @Override
    public Boolean removeCarBrandById(Long carBrandId) {
        if (carBrandRepository.existsById(carBrandId)){
            carBrandRepository.deleteById(carBrandId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

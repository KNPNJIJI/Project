package by.itacademy.service;

import by.itacademy.dao.CarDao;
import by.itacademy.dao.CarPhotoDao;
import by.itacademy.dto.CarAdminDto;
import by.itacademy.dto.CarDto;
import by.itacademy.model.Car;
import by.itacademy.model.CarPhoto;
import by.itacademy.dto.Brand;
import by.itacademy.dto.Model;
import by.itacademy.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarDao carDao;

    @Autowired
    CarPhotoDao carPhotoDao;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public void delete(Car car) {
        carDao.delete(car);
    }

    @Transactional
    public void updateActivate(int idCar){
        Car car = carDao.findById(idCar);
        car.setActive(!car.isActive());
        carDao.update(car);
    }

    @Transactional
    public void create(Car car, byte[] photo) {

        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setCar(car);
        carPhoto.setPhoto(photo);
        carPhoto.setTitle(true);

        car.setPopularity(0);
        carDao.create(car);
        carPhotoDao.create(carPhoto);
    }

    @Transactional
    public CarDto findById(int idCar,int idPhoto){
        Car car = carDao.findById(idCar);
        return convertToCarDtoDatail(car, idPhoto);
    }

    @Transactional
    public List<CarDto> findAll(){
        List<Car> cars= carDao.findAll();
        return MapperUtil.convertList(cars, this::convertToCarDto);
    }

    @Transactional
    public List<CarAdminDto> getCarForPage(int pageSize, int page){
        List<Car> cars = carDao.getCarsForPage(pageSize, page);
        return MapperUtil.convertList(cars, this::convertToCarAdminDto);
    }

    public List<Brand> findBrand(){
        return carDao.findBrand();
    }

    public List<Model> findModel(String brand){
        return carDao.findModel(brand);
    }

    @Transactional
    public List<CarDto> findCarsOfBrand(String brand){
        List<Car> cars= carDao.findCarsOfBrand(brand);
        return MapperUtil.convertList(cars, this::convertToCarDto);
    }

    @Transactional
    public List<CarDto> findCarsOfModel(String brand, String model){
        List<Car> cars= carDao.findCarsOfModel(brand, model);
        return MapperUtil.convertList(cars, this::convertToCarDto);
    }

    private CarDto convertToCarDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        List<CarPhoto> carPhotos = car.getCarPhotos();
        for(CarPhoto carPhoto : carPhotos){
            System.out.println("carPhoto "+carPhoto);
            if (carPhoto.isTitle() ) {
                carDto.setCarPhoto(carPhoto.getId());
            }
        }
        return carDto;
    }

    private CarAdminDto convertToCarAdminDto(Car car) {
        CarAdminDto carAdminDto = modelMapper.map(car, CarAdminDto.class);
        List<CarPhoto> carPhotos = car.getCarPhotos();
        for(CarPhoto carPhoto : carPhotos){
            if (carPhoto.isTitle() ) {
                carAdminDto.setCarPhoto(carPhoto.getId());
            }
        }
        return carAdminDto;
    }

    private CarDto convertToCarDtoDatail(Car car, int idPhoto) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        List<CarPhoto> carPhotos = car.getCarPhotos();
        carDto.setCarPhoto(carPhotos.get(idPhoto-1).getId());
        return carDto;
    }

    public Integer getCountPageCar(int pageSize){
        return carDao.getCountPageCar(pageSize);
    }

    // private CarPhotoDto convertToCarPhotoDto(CarPhoto carPhoto){
//        return modelMapper.map(carPhoto, CarPhotoDto.class);
//    }

}

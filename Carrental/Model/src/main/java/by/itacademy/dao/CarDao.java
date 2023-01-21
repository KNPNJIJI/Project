package by.itacademy.dao;

import by.itacademy.model.Car;
import by.itacademy.dto.Brand;
import by.itacademy.dto.Model;

import java.util.List;


public interface CarDao {

    void create(Car car);

    Car findById(Integer id);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    List<Brand> findBrand();

    List<Model> findModel(String brand);

    List<Car> findCarsOfBrand(String brand);

    List<Car> findCarsOfModel(String brand, String model);

    Integer getCountPageCar(int pageSize);

    List<Car> getCarsForPage(int pageSize, int page);
}

package by.itacademy.dao;

import by.itacademy.model.CarPhoto;

public interface CarPhotoDao {

    void create(CarPhoto photo);

    CarPhoto getTitlePhoto(String id);

    Long getCountCarPhoto(int pageSize);

   // String getIdTitlePhoto(int idCar);
}

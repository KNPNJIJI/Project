package by.itacademy.service;

import by.itacademy.dao.CarDao;
import by.itacademy.dao.CarPhotoDao;
import by.itacademy.model.CarPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarPhotoService {

    @Autowired
    CarPhotoDao carPhotoDao;

    @Autowired
    CarDao carDao;

    @Transactional
    public byte[] getTitlePhoto(String id){
        return carPhotoDao.getTitlePhoto(id).getPhoto();
    }

    @Transactional
    public void create(int idCar, byte[] photo){
        CarPhoto carPhoto = new CarPhoto();
        carPhoto.setCar(carDao.findById(idCar));
        carPhoto.setPhoto(photo);
        carPhoto.setTitle(false);
        carPhotoDao.create(carPhoto);
    }

    public Long getCountCarPhoto(int idCar){
        return carPhotoDao.getCountCarPhoto(idCar);
    }
}

package by.itacademy.dao;

import by.itacademy.model.CarPhoto;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarPhotoDaoImpl implements CarPhotoDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(CarPhoto carPhoto){
        sessionFactory.getCurrentSession().saveOrUpdate(carPhoto);
    }

    @Override
    public Long getCountCarPhoto(int idCar){

        String countQ = "Select count (c.id) from Carphotos c WHERE c.car = " + idCar;
        Query countQuery = sessionFactory.getCurrentSession().createQuery(countQ);
        return (Long)countQuery.uniqueResult();
    }

    @Override
    public CarPhoto getTitlePhoto(String id){
        return sessionFactory.getCurrentSession().get(CarPhoto.class, id);

        //String query = "FROM Car_photo WHERE car_id = " + Integer.toString(id) + " AND title = TRUE";
//        String query = "SELECT cp.id, cp.car_ID, cp.title, cp.car_PHOTO from Carphotos AS cp ";
//
//        List<CarPhoto> carPhotoList = sessionFactory.getCurrentSession().createQuery(query, CarPhoto.class).list();
//        System.out.println("DaoImpl size "+ carPhotoList.size());
//        return  carPhotoList;
    };
/*  // TODO delete this >>
    @Override
    public String getIdTitlePhoto(int idCar){
        String query = "SELECT cp.id, cp.car_ID, cp.title FROM Carphotos AS cp WHERE car_id = "
                + Integer.toString(idCar) + " AND title = TRUE";
        CarPhotoSelectDto carPhotoSelectDto = sessionFactory.getCurrentSession().createQuery(query, CarPhotoSelectDto.class).list().get(0);
        System.out.println("IdTitlePhoto "+ carPhotoSelectDto.getId());
        return carPhotoSelectDto.getId();
    } */ // TODO delete this <<
}

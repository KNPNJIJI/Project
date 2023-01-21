package by.itacademy.dao;

import by.itacademy.model.Car;
import by.itacademy.dto.Brand;
import by.itacademy.dto.Model;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Car car) {
        sessionFactory.getCurrentSession().saveOrUpdate(car);
    }

    @Override
    public Car findById(Integer id){
        return sessionFactory.getCurrentSession().get(Car.class, id);
    };

    @Override
    public void update(Car car){
        create(car);
    };

    @Override
    public void delete(Car car){
        Car loadedCar = sessionFactory.getCurrentSession().load(Car.class, car.getId());
        sessionFactory.getCurrentSession().delete(loadedCar);
    };

    @Override
    public List<Car> findAll(){
        return sessionFactory.getCurrentSession().createQuery("from Car", Car.class).list();
    }

    @Override
    public List<Brand> findBrand(){
        String query = "SELECT c.brand FROM Car AS c GROUP BY Brand";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<Model> findModel(String brand){
        String query = "SELECT c.model FROM Car AS c WHERE Brand = '" + brand + "' GROUP BY Model";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<Car> findCarsOfBrand(String brand){
        String query = "FROM Car AS c WHERE Brand = '" + brand + "'";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<Car> findCarsOfModel(String brand, String model){
        String query = "FROM Car AS c WHERE Brand = '" + brand + "' AND Model = '" + model + "'";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public Integer getCountPageCar(int pageSize){

        String countQ = "Select count (c.id) from Car c";
        Query countQuery = sessionFactory.getCurrentSession().createQuery(countQ);
        Long countResults = (Long) countQuery.uniqueResult();
        System.out.println("countResults " + countResults);
        int lastPageNumber = (int) (Math.ceil((double )countResults / (double )pageSize));
        return lastPageNumber;
    }

    @Override
    public List<Car> getCarsForPage(int pageSize, int page){

        Query selectQuery = sessionFactory.getCurrentSession().createQuery("From Car");
        selectQuery.setFirstResult((page - 1) * pageSize);
        selectQuery.setMaxResults(pageSize);
        List<Car> carsForPage = selectQuery.list();
        return carsForPage;
    }
}

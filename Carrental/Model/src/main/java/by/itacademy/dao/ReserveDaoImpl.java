package by.itacademy.dao;

import by.itacademy.model.Reserve;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
@Transactional
public class ReserveDaoImpl implements ReserveDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Reserve reserve){
        sessionFactory.getCurrentSession().saveOrUpdate(reserve);
    };

    //@Override
    public void selectCarIdBetweenDate(Date date){

        //sessionFactory.getCurrentSession().saveOrUpdate(reserve);
    };

    public void selectCarIdBetweenDates(Date dateFrom, Date dateTo){

        //sessionFactory.getCurrentSession().saveOrUpdate(reserve);
    };
}

package by.itacademy.dao;

import by.itacademy.dto.Brand;
import by.itacademy.model.Reserve;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public class ReserveDaoImpl implements ReserveDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Reserve reserve){
        sessionFactory.getCurrentSession().saveOrUpdate(reserve);
    };

    @Override
    public List<Reserve> selectCarIdBetweenDate(Date date){
        String query = "FROM Reserve WHERE '"+date+"' BETWEEN RESERVE_DATE_FROM AND RESERVE_DATE_TO";
        List<Reserve> list = sessionFactory.getCurrentSession().createQuery(query).list();
        return list;
    };

    @Override
    public List<Reserve> selectCarIdBetweenDates(Date dateFrom, Date dateTo){
        String query = "FROM  Reserve " +
                "WHERE ('"+dateFrom+"' BETWEEN RESERVE_DATE_FROM AND RESERVE_DATE_TO) " +
                "OR ('"+dateTo+"' BETWEEN RESERVE_DATE_FROM AND RESERVE_DATE_TO) " +
                "OR (RESERVE_DATE_FROM BETWEEN '"+dateFrom+"' AND '"+dateTo+"') " +
                "OR (RESERVE_DATE_TO BETWEEN '"+dateFrom+"' AND '"+dateTo+"')";
        List<Reserve> list = sessionFactory.getCurrentSession().createQuery(query).list();
        return list;
    };
}

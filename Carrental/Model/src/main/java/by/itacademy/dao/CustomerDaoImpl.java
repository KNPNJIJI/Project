package by.itacademy.dao;

import by.itacademy.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Customer customer){
        sessionFactory.getCurrentSession().saveOrUpdate(customer);
    }
}

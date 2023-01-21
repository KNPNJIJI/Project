package by.itacademy.dao;

import by.itacademy.model.AppUser;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
@ComponentScan(basePackages = {"by.itacademy"})
public class AppUserDaoImpl implements AppUserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AppUser> findByUserName(String username) {
        return sessionFactory.getCurrentSession()
                .createQuery("from AppUser au where au.username=:username", AppUser.class)
                .setParameter("username", username)
                .list();
    }
}

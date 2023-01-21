package by.itacademy.service;

import by.itacademy.dao.AppUserDao;
import by.itacademy.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan(basePackages = {"by.itacademy.dao"})
public class AppUserService {

    @Autowired
    AppUserDao appUserDao;

    public List<AppUser> findUserByUsername(String username) {
        System.out.println("Search for user: " + username);
        return appUserDao.findByUserName(username);
    }
}

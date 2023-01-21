package by.itacademy.dao;

import by.itacademy.model.AppUser;

import java.util.List;

public interface AppUserDao {

    List<AppUser> findByUserName(String username);
}

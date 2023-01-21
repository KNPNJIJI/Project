package by.itacademy.dao;

import by.itacademy.model.Reserve;

import java.sql.Date;
import java.util.List;

public interface ReserveDao {

    void create(Reserve reserve);

    List<Reserve> selectCarIdBetweenDate(Date date);

    List<Reserve> selectCarIdBetweenDates(Date dateFrom, Date dateTo);
}

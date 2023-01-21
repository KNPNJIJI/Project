package by.itacademy.service;

import by.itacademy.dao.CustomerDao;
import by.itacademy.dao.ReserveDao;
import by.itacademy.dto.ReserveDto;
import by.itacademy.model.Customer;
import by.itacademy.model.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan(basePackages = {"by.itacademy.dao"})
public class ReserveService {

    @Autowired
    ReserveDao reserveDao;

    @Autowired
    CustomerDao customerDao;

    public void addReserve(int carID, ReserveDto reserveDto){

        Customer customer = new Customer(null,
                reserveDto.getFirstName(),
                reserveDto.getLastName(),
                reserveDto.getPhone(),
                reserveDto.getEmail());
        customerDao.create(customer);

        Reserve reserve = new Reserve(null,
                carID,
                customer.getID(),
                reserveDto.getStartRent(),
                reserveDto.getEndRent());
        reserveDao.create(reserve);
    }
}

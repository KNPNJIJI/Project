package by.itacademy.service;

import by.itacademy.dao.CustomerDao;
import by.itacademy.dao.ReserveDao;
import by.itacademy.dto.CarDto;
import by.itacademy.dto.ReserveDto;
import by.itacademy.model.Customer;
import by.itacademy.model.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@ComponentScan(basePackages = {"by.itacademy.dao"})
public class ReserveService {

    @Autowired
    ReserveDao reserveDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    private CarService carService;

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

    public List<CarDto> selectCarIdBetweenDatesOfBrand(Date dateFrom, Date dateTo, String brand){
        List<Reserve> listReserve = reserveDao.selectCarIdBetweenDates(dateFrom, dateTo);
        String filterCars = getFilterCars(listReserve);
        System.out.println("Controller equals( ) 444 " + filterCars);
        if(brand.equals("all") && filterCars.equals("")) {
            System.out.println("Controller equals( ) 321 " + filterCars);
            return carService.findAll();
        }
        System.out.println("Controller startRent 321 " + filterCars);
        if(brand.equals("all")) {
            return carService.findCarsBesides(filterCars);
        }
        System.out.println("Controller startRent 222 " + filterCars);
        return carService.findCarsOfBrandBesides(brand, filterCars);
    }

    public List<CarDto> selectCarIdBetweenDatesOfModel(Date dateFrom, Date dateTo, String brand, String model){
        List<Reserve> listReserve = reserveDao.selectCarIdBetweenDates(dateFrom, dateTo);
        String filterCars = getFilterCars(listReserve);
        return carService.findCarsOfModelBesides(brand, model, filterCars);
    }

    private String getFilterCars(List<Reserve> listReserve ){
        String result = "";

        if (listReserve.size() == 0){
            return result;
        }

        if (listReserve.size() == 1){
            return " id != '" + listReserve.get(0).getCAR_ID().toString() + "' ";
        }

        for(Reserve reserve : listReserve){
            if(result.equals("")){
                result = " id != '" + reserve.getCAR_ID().toString()+ "' ";
            } else {
                result = " AND id != '" + reserve.getCAR_ID().toString()+ "' ";
            }
        }

        return result;
    }
}

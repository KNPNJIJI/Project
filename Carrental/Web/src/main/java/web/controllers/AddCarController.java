package web.controllers;

import by.itacademy.model.Car;
import by.itacademy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AddCarController {

    @Autowired
    private CarService carService;

    @GetMapping("/admin-console/car.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String ShowAddCarPage() {
        return "add_car";
    }

    @PostMapping("/admin-console/car.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @SneakyThrows
    public ModelAndView addCar(@RequestParam("photo") MultipartFile file, Car car) {
        carService.create(car, file.getBytes());
        int pageSize = 3;
        int currentPage = 1;
        int totalPages = carService.getCountPageCar(pageSize);

        return new ModelAndView(
                "cars_list",
                Map.of("totalPages", totalPages,
                        "currentPage", currentPage,
                        "cars", carService.getCarForPage(pageSize, currentPage)
                ));
    }
}

package web.controllers;

import by.itacademy.service.CarPhotoService;
import by.itacademy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @GetMapping("/admin-console")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    //@Secured("ROLE_ADMIN") // TODO
    public String adminPage() {
        return "adminPage";
    }

    @GetMapping("/admin-console/cars.html")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView showCarsDef() {
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

    @GetMapping("/admin-console/cars/page={page}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView showCarsForPageNum(@PathVariable("page") Integer page) {
        System.out.println("showCarsForPageNum.page " + page);
        int pageSize = 3;

        int totalPages = carService.getCountPageCar(pageSize);

        return new ModelAndView(
                "cars_list",
                Map.of("totalPages", totalPages,
                        "currentPage", page,
                        "cars", carService.getCarForPage(pageSize, page)
                ));
    }

//    @GetMapping("/admin-console/car={id}")
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    public ModelAndView showCarDatail( @PathVariable("id") Integer id) {
//        return new ModelAndView(
//                "car_datail",
//                Map.of( "car", carService.findById(id))
//        );
//    }

}

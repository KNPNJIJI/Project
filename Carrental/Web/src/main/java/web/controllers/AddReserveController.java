package web.controllers;

import by.itacademy.dto.ReserveDto;
import by.itacademy.service.CarService;
import by.itacademy.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@ComponentScan(basePackages = {"by.itacademy.service"})
public class AddReserveController {

    @Autowired
    private CarService carService;

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/add-reserve/carid={carid}")
    public ModelAndView ShowAddReservePage(@PathVariable("carid") int carID) {
        return new ModelAndView(
                "add_reserve",
                Map.of( "car", carService.findById(carID, 1))
        );
    }

    @PostMapping("/add-reserve/carid={carid}")
    public String addReserve(@PathVariable("carid") int carID, ReserveDto reserveDto) {
        reserveService.addReserve(carID, reserveDto);
        return "index";
    }
}

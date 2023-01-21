package web.controllers;

import by.itacademy.dto.CarDto;
import by.itacademy.model.Reserve;
import by.itacademy.service.CarPhotoService;
import by.itacademy.service.CarService;
import by.itacademy.dto.Model;
import by.itacademy.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @Autowired
    private ReserveService reserveService;

    @GetMapping({"/", "/index.html"})
    public ModelAndView homePage() {
        return new ModelAndView(
                "index",
                Map.of( "brands", carService.findBrand())
        );
    }

    @GetMapping(value = "/model/brand={brand}")
    @ResponseBody
    public List<Model> getModel(@PathVariable("brand") String brand) {
        System.out.println("brand from front: "+brand);
        List<Model> list = carService.findModel(brand);
        for(Object model1 : list){
            System.out.println("model1 "+model1);
        }
        return list;
    }

    @GetMapping("/api/cars/brand={brand}")
    @ResponseBody
    public List<CarDto> showCars(@PathVariable("brand") String brand) {

        if(brand.equals("all")) {
            return carService.findAll();
        }

        return carService.findCarsOfBrand(brand);
    }

    @ResponseBody
    @GetMapping("/image/photo/id={idPhoto}")
    public byte[] getImage(@PathVariable("idPhoto") String idPhoto) {
        System.out.println("Controller idPhoto " + idPhoto);
        return carPhotoService.getTitlePhoto(idPhoto);
    }

    @GetMapping("/api/cars/brand={brand}/model={model}")
    @ResponseBody
    public List<CarDto> showCarsOfModel(
            @PathVariable("brand") String brand,
            @PathVariable("model") String model) {

        return carService.findCarsOfModel(brand, model);
    }

    @GetMapping("/api/cars/startRent={startRent}/endRent={endRent}/brand={brand}")
    @ResponseBody
    public List<CarDto> showCarsBetweenDateOfBrand(
            @PathVariable("startRent") Date startRent,
            @PathVariable("endRent") Date endRent,
            @PathVariable("brand") String brand) {
        List<CarDto> list = reserveService.selectCarIdBetweenDatesOfBrand(startRent, endRent, brand);
        return list;
    }

    @GetMapping("/api/cars/startRent={startRent}/endRent={endRent}/brand={brand}/model={model}")
    @ResponseBody
    public List<CarDto> showCarsBetweenDateOfModel(
                                             @PathVariable("startRent") Date startRent,
                                             @PathVariable("endRent") Date endRent,
                                             @PathVariable("brand") String brand,
                                             @PathVariable("model") String model) {
        List<CarDto> list = reserveService.selectCarIdBetweenDatesOfModel(startRent, endRent, brand, model);
        return carService.findCarsOfBrand(brand);
    }
}

package web.controllers;

import by.itacademy.service.CarPhotoService;
import by.itacademy.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class CarDatailController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

//    @GetMapping("/admin-console/car={id}/photo={pid}")
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @ResponseBody
//    public ModelAndView showCarDatailForAdm( @PathVariable("id") Integer id, @PathVariable("pid") Integer pid)  {
//        Long totalPhoto = carPhotoService.getCountCarPhoto(1);
//
//        return new ModelAndView(
//                "car_datail",
//                Map.of( "totalPhoto", totalPhoto,
//                        "currentPhoto", pid,
//                        "car", carService.findById(id))
//        );
//    }

    @GetMapping("/car={id}/photo={pid}")
    @ResponseBody
    public ModelAndView showCarDatail( @PathVariable("id") Integer idCar, @PathVariable("pid") Integer idPhoto)  {
        Long totalPhoto = carPhotoService.getCountCarPhoto(idCar);

        return new ModelAndView(
                "car_datail",
                Map.of( "totalPhoto", totalPhoto,
                        "currentPhoto", idPhoto,
                        "car", carService.findById(idCar, idPhoto))
        );
    }

    @PutMapping("/admin-console/deactivate/car={id}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @ResponseBody
    public void deactivateCar( @PathVariable("id") Integer idCar){
        carService.updateActivate(idCar);
    }
}

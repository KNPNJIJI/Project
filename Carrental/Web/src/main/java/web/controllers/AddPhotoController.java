package web.controllers;

import by.itacademy.service.CarPhotoService;
import by.itacademy.service.CarService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AddPhotoController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarPhotoService carPhotoService;

    @GetMapping("/image/add-photo/carid={carid}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public ModelAndView ShowAddPhotoPage(@PathVariable("carid") int carID) {
        return new ModelAndView(
                "add_photo",
                Map.of( "car", carService.findById(carID, 1))
        );
    }

    @PostMapping("/image/add-photo/carid={carid}")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @SneakyThrows
    public ModelAndView addPhoto(@RequestParam("photo") MultipartFile file, @PathVariable("carid") int carID) {

        carPhotoService.create(carID, file.getBytes());

        Long totalPhoto = carPhotoService.getCountCarPhoto(carID);

        return new ModelAndView(
                "car_datail",
                Map.of( "totalPhoto", totalPhoto,
                        "currentPhoto", 1,
                        "car", carService.findById(carID, 1))
        );
    }
}

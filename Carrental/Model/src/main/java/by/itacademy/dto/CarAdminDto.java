package by.itacademy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarAdminDto {

    Integer id;
    String carPhoto;
    String brand;
    String model;
    Integer price;
    Integer yearManufacture;
    Integer popularity;
    Boolean active;
}

package by.itacademy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @JsonProperty("Id")
    Integer id;

    @JsonProperty("Brand")
    String brand;

    @JsonProperty("Model")
    String model;

    @JsonProperty("Year Manufacture")
    Integer yearManufacture;

    @JsonProperty("CarPhoto")
    String carPhoto;

    @JsonProperty("Price")
    Integer price;
}

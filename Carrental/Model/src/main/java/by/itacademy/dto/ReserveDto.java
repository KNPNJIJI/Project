package by.itacademy.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class ReserveDto {

    String firstName;
    String lastName;
    String phone;
    String email;
    Date startRent;
    Date endRent;
}

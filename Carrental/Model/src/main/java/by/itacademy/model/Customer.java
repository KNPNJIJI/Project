package by.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long ID;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "CELL_PHONE")
    private String cellPhone;

    @Column(name = "EMAIL")
    private String email;
}

package by.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Reserve")
@NoArgsConstructor
@AllArgsConstructor
public class Reserve {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Long ID;

    @Column(name = "CAR_ID")
    private Integer CAR_ID;

    @Column(name = "CUSTOMER")
    private Long CUSTOMER_ID;

    @Column(name = "RESERVE_DATE_FROM")
    private Date RESERVE_DATE_FROM;

    @Column(name = "RESERVE_DATE_TO")
    private Date RESERVE_DATE_TO;
}

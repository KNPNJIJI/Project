package by.itacademy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car  {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "Price")
    private Integer price;

    @Column(name = "Year_of_manufacture")
    private Integer yearManufacture;

    @Column(name = "Popularity")
    private Integer popularity;

    @Column(name = "active")
    private boolean active;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarPhoto> carPhotos;
}

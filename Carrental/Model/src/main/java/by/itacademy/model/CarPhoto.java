package by.itacademy.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Carphotos")
@Table(name = "CarPhotos")
@Getter
@Setter
public class CarPhoto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car car;

    @Column(name = "title")
    private boolean title;

    @Lob
    @Column(name = "CAR_PHOTO", columnDefinition = "MEDIUMBLOB NOT NULL")
    private byte[] photo;
}

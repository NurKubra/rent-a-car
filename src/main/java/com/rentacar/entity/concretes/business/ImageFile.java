package com.rentacar.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentacar.entity.concretes.business.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "imageFile_Car",
            joinColumns = @JoinColumn(name = "imageFile_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )private List<Car> cars;

    private String fileName;

    @Lob
    @Column(name = "imageData")
    private byte[] imageData;
}
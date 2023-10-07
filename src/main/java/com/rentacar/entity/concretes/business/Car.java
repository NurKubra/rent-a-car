package com.rentacar.entity.concretes.business;

import com.rentacar.entity.enums.FuelType;
import com.rentacar.entity.enums.TransmissionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 15)
    @NotNull(message = "Car's  make can not be null")
    private String make;

    @Size(min = 2, max = 15)
    @NotNull(message = "Car's  model can not be null")
    private String model;

    @NotNull(message = "Car's  year can not be null")
    private int year;

    @NotNull(message = "Car's  color can not be null")
    private String color;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    private Boolean isAvailable;

    @ManyToMany
    private List<ImageFile> imageFile;




}

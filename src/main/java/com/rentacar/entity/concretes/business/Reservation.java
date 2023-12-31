package com.rentacar.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentacar.entity.abstracts.User;
import com.rentacar.entity.concretes.user.Customer;
import com.rentacar.entity.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Reservation {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ReservationStatus reservationStatus;

    // customer (Admin in de reservation yapabilmesi icin User konulabilir)


    //check joincolumn?

    @OneToOne
    private Car car;

    private boolean babyCarSeatRequested;

    private boolean navigationDeviceRequested;

    @NotNull(message = "Start date mustn't be empty")
    @Column(name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "End date mustn't be empty")
    @Column(name = "end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;


    @ManyToOne
    private Customer customer;

}

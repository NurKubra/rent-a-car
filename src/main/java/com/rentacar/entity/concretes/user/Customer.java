package com.rentacar.entity.concretes.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentacar.entity.abstracts.User;
import com.rentacar.entity.concretes.business.Reservation;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)

public class Customer  extends User {

    @NotNull
    @Column(unique = true)
    private String email;


    private boolean isActive;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
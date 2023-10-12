package com.rentacar.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentacar.entity.concretes.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username mustn't be empty")
    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String surname;

    @Column(length = 120, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String birthplace;

    @Column(length = 50, nullable = false)
    private String birthday;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(name = "user_roles_table",
            joinColumns = @JoinColumn(name = "userRole_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserRole> roles = new HashSet<>();



}

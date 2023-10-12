package com.rentacar.entity.concretes.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentacar.entity.abstracts.User;
import com.rentacar.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="user_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType roleType;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "user_user_roles_table",
            joinColumns = @JoinColumn(name = "userRole_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList;






}

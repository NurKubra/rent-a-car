package com.rentacar.contactmessage;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
// ContactMessage  sınıfına parametresiz bir yapılandırıcı (constructor) ekler.
// ContactMessage  sınıfının her özelliği için bir setter metodu ekler.
  //      Bir  ContactMessage Builder iç içe sınıfı oluşturur ve bu sınıf, nesne oluşturma işlemini kolaylaştırmak için kullanılır.
public class ContactMessage {       //  POJO  class

    @Id      // P.K icin
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String subject;

    @NotNull
    private String message;

    // 2025-06-05
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;


}

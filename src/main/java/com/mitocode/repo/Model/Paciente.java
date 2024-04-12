package com.mitocode.repo.Model;



import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "paciente")
public class Paciente extends RepresentationModel<Paciente> {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_paciente", nullable = false)
    private String id_paciente;
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "phone", nullable = false)
    @Size(min=10,max=10)
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phone;
    @Column(name = "email", nullable = false)
    @Email(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
}

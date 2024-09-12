package br.com.luismarrocos.medicalconsult.user.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private long idUser;
    @Column(name = "NAME_USER")

    private String nameUser;
    @Column(name = "EMAIL")

    private String email;
    @Column(name = "CPF")

    private String cpf;
    @Column(name = "FONE")

    private String fone;
    @Column(name = "BIRTH_DATE")

    private Date birthDate;

    public int getId(){
        return (int) idUser;
    };

    public void setId(Long id) {
    }
}

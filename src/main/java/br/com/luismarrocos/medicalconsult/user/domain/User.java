package br.com.luismarrocos.medicalconsult.user.domain;

import br.com.luismarrocos.medicalconsult.consult.domain.Consult;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consult> consults = new ArrayList<>();

    public int getId(){
        return (int) idUser;
    };

    public void setId(Long id) {
        this.idUser = id;
    }


}

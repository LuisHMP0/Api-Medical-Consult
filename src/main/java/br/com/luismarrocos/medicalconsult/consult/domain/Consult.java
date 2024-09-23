package br.com.luismarrocos.medicalconsult.consult.domain;

import br.com.luismarrocos.medicalconsult.user.domain.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CONSULTS")
public class Consult {
    @Id
    @GeneratedValue
    @Column(name = "ID_CONSULT")
    private long idConsult;

    @Column(name = "CONSULT_DATE")
    private long consultDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    private User user;
}

package br.com.luismarrocos.medicalconsult.consult.domain;

import br.com.luismarrocos.medicalconsult.user.domain.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "PROFESSIONAL")
    private String professional;

    @Column(name = "SPECIALTY")
    private String specialty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", nullable = false)
    @JsonBackReference
    private User user;

    public Consult() {

    }

    public Consult(Long idConsult, Long consultDate, String professional, String specialty) {
        this.idConsult = idConsult;
        this.consultDate = consultDate;
        this.professional = professional;
        this.specialty = specialty;
        this.user = user;
    }

    public void setIdConsult(Long o) {
    }
}

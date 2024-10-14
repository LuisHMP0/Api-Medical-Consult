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
    private String consultDate;

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

    public Consult(Long idConsult, String consultDate, String professional, String specialty) {
        this.idConsult = idConsult;
        this.consultDate = consultDate;
        this.professional = professional;
        this.specialty = specialty;
        this.user = user;
    }

    public void setIdConsult(Long o) {
    }

    public long getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(long idConsult) {
        this.idConsult = idConsult;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
        this.consultDate = consultDate;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

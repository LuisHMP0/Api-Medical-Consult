package br.com.luismarrocos.medicalconsult.consult.repositories;

import br.com.luismarrocos.medicalconsult.consult.domain.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultRepository extends JpaRepository<Consult, Long> {
}

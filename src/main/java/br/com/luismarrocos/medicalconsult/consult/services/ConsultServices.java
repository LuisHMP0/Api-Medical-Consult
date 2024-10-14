package br.com.luismarrocos.medicalconsult.consult.services;

import br.com.luismarrocos.medicalconsult.consult.domain.Consult;
import br.com.luismarrocos.medicalconsult.consult.repositories.ConsultRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultServices {
    @Autowired
    private ConsultRepository consultRepository;

    public Consult registerConsult(Consult consult) {
        consult.setIdConsult(null);
        return consultRepository.save(consult);
    }

    public List<Consult> listConsults() {
        return consultRepository.findAll();
    }

    public Consult searchConsult(Long id) {
        Optional<Consult> consult = consultRepository.findById(id);
        return consult.orElseThrow(
                () -> new ObjectNotFoundException(id, "Consulta não encontrada! ID: " + id));
    }

    public void deleteConsult(Long id) throws Exception {
        searchConsult(id);
        try {
            consultRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Não é possivel excluir, porque há entidades relacionadas.");
        }
    }

    public Consult updateConsult(Consult consult) {
        Consult newConsult = searchConsult(consult.getIdConsult());
        updateData(newConsult, consult);
        return consultRepository.save(newConsult);
    }

    private void updateData(Consult newConsult, Consult consult) {
        newConsult.setConsultDate(consult.getConsultDate());
        newConsult.setProfessional(consult.getProfessional());
        newConsult.setSpecialty(consult.getSpecialty());
    }
}

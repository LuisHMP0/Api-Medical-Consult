package br.com.luismarrocos.medicalconsult.consult.resources;

import br.com.luismarrocos.medicalconsult.consult.domain.Consult;
import br.com.luismarrocos.medicalconsult.consult.services.ConsultServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/consults")
public class ConsultResource {

    @Autowired
    private ConsultServices consultServices;

    @GetMapping
    public ResponseEntity<List<Consult>> findAll() {
        List<Consult> list = consultServices.listConsults();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Consult> findById(@PathVariable Long id) {
        Consult consult = consultServices.searchConsult(id);
        return ResponseEntity.ok().body(consult);
    }

    @PostMapping
    public ResponseEntity<Consult> insert(@RequestBody Consult consult) {
        Consult newConsult = consultServices.registerConsult(consult);
        return ResponseEntity.ok().body(newConsult);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Consult> updateConsult(@RequestBody Consult consult, @PathVariable Long id) {
        consult.setIdConsult((id));
        Consult updatedConsult = consultServices.updateConsult(consult);
        return ResponseEntity.ok().body(updatedConsult);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            consultServices.deleteConsult(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

package br.com.luismarrocos.medicalconsult.user.resources;

import br.com.luismarrocos.medicalconsult.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    @Autowired
    private UserService service;
}

package br.com.luismarrocos.medicalconsult.user.resources;

import br.com.luismarrocos.medicalconsult.user.domain.User;
import br.com.luismarrocos.medicalconsult.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public int saveUser(@RequestBody User user) {
        User savedUser = service.saveUser(user);
        return savedUser.getId();
    }

    @GetMapping("/{idUser}")
    public User getUser(@PathVariable("idUser") int idUser) {
        return service.getUserById(idUser);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}

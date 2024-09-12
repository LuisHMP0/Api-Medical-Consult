package br.com.luismarrocos.medicalconsult.user.resources;

import br.com.luismarrocos.medicalconsult.user.domain.User;
import br.com.luismarrocos.medicalconsult.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public int saveUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long idUser,
            @RequestBody User userUpdated) {

        if (!userRepository.existsById(idUser)) {
            return ResponseEntity.notFound().build();
        }

        userUpdated.setId(idUser);
        User user = userRepository.save(userUpdated);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUser(@PathVariable Long idUser) {
        return userRepository.findById(idUser)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long idUser) {
        if (!userRepository.existsById(idUser)) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(idUser);
        return ResponseEntity.noContent().build();
    }

}

package br.com.luismarrocos.medicalconsult.user.services;

import br.com.luismarrocos.medicalconsult.user.domain.User;
import br.com.luismarrocos.medicalconsult.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById((long) id);
        return user.orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }


}



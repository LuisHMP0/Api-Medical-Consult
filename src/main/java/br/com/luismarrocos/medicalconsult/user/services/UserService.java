package br.com.luismarrocos.medicalconsult.user.services;

import br.com.luismarrocos.medicalconsult.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}

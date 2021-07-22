package com.sparta.eng87.finalproject.services;

import com.sparta.eng87.finalproject.entities.UserEntity;
import com.sparta.eng87.finalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public String changePassword(String username, String password1, String password2) {

        if (password1.equals(password2)) {
            UserEntity currentUser = userRepository.getCurrentUser(username);

            currentUser.setUserPassword(encoder.encode(password1));
            userRepository.save(currentUser);
            return "Password Updated";
        } else {
            return "Invalid Details";
        }
    }
}

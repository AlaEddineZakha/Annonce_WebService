package com.example.Annonce_ServiceWeb.Services;

import com.example.Annonce_ServiceWeb.model.User;
import com.example.Annonce_ServiceWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getUserByName(String username){
        return userRepository.findByUsername( username );
    }
}

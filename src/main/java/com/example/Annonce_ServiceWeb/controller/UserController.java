package com.example.Annonce_ServiceWeb.controller;

import com.example.Annonce_ServiceWeb.Services.UserService;
import com.example.Annonce_ServiceWeb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/view/{username}")
    public Optional<User> getUsername(@Valid @PathVariable String username){
        return userService.getUserByName(username);
    }
}

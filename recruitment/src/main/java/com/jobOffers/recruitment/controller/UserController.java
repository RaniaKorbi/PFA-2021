package com.jobOffers.recruitment.controller;
import com.jobOffers.recruitment.model.User;
import com.jobOffers.recruitment.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")

public class UserController {
    private  final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        User user= userService.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser= userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    //@Secured(value={"ROLE_AGENT"})
    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User UpdateUser= userService.updateUser(user);
        return new ResponseEntity<>(UpdateUser, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<?> deleteUser(@PathVariable("email") String email){
        userService.deleteUser(email);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}


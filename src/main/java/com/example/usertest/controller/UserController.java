package com.example.usertest.controller;

import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import com.example.usertest.service.user.UserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserSV userSV;


    @GetMapping("{id}")
    public StructureRS show(@PathVariable("id") int id) {

        return userSV.getUserById(id);

    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody UserRQ userRQ,
                             @RequestParam(defaultValue = "sport") String hobby) {

        userRQ.setHobby(hobby);
        StructureRS structureRS = userSV.addUser(userRQ);

        return new ResponseEntity<>(structureRS, HttpStatus.CREATED);

    }

}

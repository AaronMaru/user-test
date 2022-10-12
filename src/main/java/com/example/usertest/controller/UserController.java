package com.example.usertest.controller;

import com.example.usertest.request.UserRQ;
import com.example.usertest.response.StructureRS;
import com.example.usertest.service.user.UserSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserSV userSV;


    @GetMapping("{id}")
    public StructureRS show(@PathVariable("id") Long id) {

        return userSV.getUserById(id);

    }

    @PostMapping
    public StructureRS store(@Valid @RequestBody UserRQ userRQ,
                             @RequestParam(defaultValue = "sport") String hobby) {
        userRQ.setHobby(hobby);
        return userSV.addUser(userRQ);

    }

}

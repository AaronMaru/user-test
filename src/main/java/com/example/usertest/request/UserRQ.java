package com.example.usertest.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRQ {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Age is mandatory")
    private int age;
    @NotBlank(message = "Country is mandatory")
    private String country;
    private String hobby;

}

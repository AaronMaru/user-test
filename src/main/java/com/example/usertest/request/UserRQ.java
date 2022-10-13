package com.example.usertest.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserRQ {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Age is mandatory")
    @Min(value = 19 , message = "User age must greater than 18")
    private int age;
    @NotBlank(message = "Country is mandatory")
    private String country;
    private String hobby;

}

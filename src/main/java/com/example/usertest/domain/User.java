package com.example.usertest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User extends BaseEntity{
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    private int id;
    private String name;
    private int age;
    private String country;
    private String hobby;

}

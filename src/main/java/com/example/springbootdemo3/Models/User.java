package com.example.springbootdemo3.Models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private Integer age;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "userNotInfo",cascade = CascadeType.ALL)
    List<Notification>notificationList = new ArrayList<>();



}

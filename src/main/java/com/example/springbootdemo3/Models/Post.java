package com.example.springbootdemo3.Models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String content;
    private Time posttime;
    private Boolean postlike;

    @ManyToOne
    @JoinColumn(name = "userInfo")
    private User user;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    List<Notification> notificationList = new ArrayList<>();

}

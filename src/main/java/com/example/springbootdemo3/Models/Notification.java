package com.example.springbootdemo3.Models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notification{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    private Time time;

    @ManyToOne
    @JoinColumn(name = "postInfo")
    private Post post;

    @ManyToOne
    @JoinColumn(name ="userNotInfo")
    private User userNotInfo;
}

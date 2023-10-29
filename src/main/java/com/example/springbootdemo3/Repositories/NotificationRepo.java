package com.example.springbootdemo3.Repositories;

import com.example.springbootdemo3.Models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Integer> {

}

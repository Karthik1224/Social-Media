package com.example.springbootdemo3.Services;


import com.example.springbootdemo3.Models.User;
import com.example.springbootdemo3.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public String addUser(User user)
    {
        userRepo.save(user);
        return "added successfully";
    }

    public Integer  NoOfNotifications()
    {

           List<User> userList = userRepo.findAll();
           if(userList.isEmpty()) return 0;
           int count=0;
           Integer userId = null;
           for(User user : userList)
           {
               if(user.getNotificationList().size()>count)
               {
                   count = user.getNotificationList().size();
                   userId = user.getUserId();
               }
           }
           return userId;



    }
}

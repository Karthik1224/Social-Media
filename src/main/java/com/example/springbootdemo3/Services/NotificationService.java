package com.example.springbootdemo3.Services;

import com.example.springbootdemo3.Models.Notification;
import com.example.springbootdemo3.Models.Post;
import com.example.springbootdemo3.Models.User;
import com.example.springbootdemo3.Repositories.NotificationRepo;
import com.example.springbootdemo3.Repositories.PostRepo;
import com.example.springbootdemo3.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    public String addNotification(Notification notification)
    {
         notificationRepo.save(notification);
         return "added";
    }

    public String mapPostAndNotification(Integer notificationId,Integer postId)
    {
        Optional<Notification>optionalNotification = notificationRepo.findById(notificationId);
        if(optionalNotification.isEmpty()) return "invalid id";

        Optional<Post>optionalPost = postRepo.findById(postId);
        if(optionalPost.isEmpty()) return "invalid postId";

        Post p = optionalPost.get();
        Notification n = optionalNotification.get();
        List<Notification>notificationList = p.getNotificationList();
        notificationList.add(n);
        n.setPost(p);
        User user = p.getUser();
        List<Notification>usernotificationlist = user.getNotificationList();
        usernotificationlist.add(n);
        userRepo.save(user);
        return "mapped";
    }

    public String sendNotification()
    {
          List<Notification>notificationList = notificationRepo.findAll();
          if(notificationList.isEmpty()) return "no notifications";

          for(Notification n : notificationList)
          {
              Post p = n.getPost();
              if(p.getPostlike()==true)
              {
                  User user = p.getUser();
                  List<Notification>userNotificationList = user.getNotificationList();
                  userNotificationList.add(n);
                  userRepo.save(user);

              }
          }
          return "sent notification successfully";
    }
}

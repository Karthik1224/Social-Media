package com.example.springbootdemo3.Controllers;

import com.example.springbootdemo3.Models.Notification;
import com.example.springbootdemo3.Services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotifController {
    @Autowired
    private NotificationService notificationService;
    @PostMapping("/addNotification")
    public String addNotification(@RequestBody Notification notification)
    {
        return notificationService.addNotification(notification);
    }

    @PostMapping("/mapPostAndNotification")
    public String mapPostAndNotification(@RequestParam Integer notificationId, @RequestParam Integer postId)
    {
        return notificationService.mapPostAndNotification(notificationId, postId);
    }

    @PutMapping("/sendNotification")
    public String sendNotification()
    {
        return notificationService.sendNotification();
    }
}

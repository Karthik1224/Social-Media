package com.example.springbootdemo3.Controllers;

import com.example.springbootdemo3.Models.Post;
import com.example.springbootdemo3.Models.User;
import com.example.springbootdemo3.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @PostMapping("/addPost")
    public String addPost(@RequestBody Post post)
    {
        return postService.addPost(post);
    }


    @PostMapping("/mapUserAndPost")
    public String mapUserAndPost(@RequestParam Integer userId, @RequestParam Integer postId)
    {
        return postService.mapUserAndPost(userId, postId);
    }

    @PutMapping("/likePost")
    public String PostLike(@RequestParam Integer postId)
    {
        return postService.PostLike(postId);
    }
}

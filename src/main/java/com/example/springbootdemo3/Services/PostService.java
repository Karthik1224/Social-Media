package com.example.springbootdemo3.Services;

import com.example.springbootdemo3.Models.Post;
import com.example.springbootdemo3.Models.User;
import com.example.springbootdemo3.Repositories.PostRepo;
import com.example.springbootdemo3.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;
    public String addPost(Post post)
    {
        postRepo.save(post);
         return "added successfully";
    }

    public String mapUserAndPost(Integer userId,Integer postId)
    {
        Optional<User>optionalUser = userRepo.findById(userId);
        if(optionalUser.isEmpty()) return "invalid userId";

        Optional<Post>optionalPost = postRepo.findById(postId);
        if(optionalPost.isEmpty()) return "invalid postId";

        User user = optionalUser.get();
        Post post = optionalPost.get();

        List<Post> postList = user.getPostList();
        postList.add(post);

        post.setUser(user);

        userRepo.save(user);
        return "mapped successfully";
    }

    public String PostLike(Integer postId)
    {
          Optional<Post>optionalPost = postRepo.findById(postId);
          if(optionalPost.isEmpty()) return "invalid postId";

          Post post = optionalPost.get();
          post.setPostlike(true);
          postRepo.save(post);
          return "likedPost";
    }
}

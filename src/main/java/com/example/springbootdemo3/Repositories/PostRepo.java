package com.example.springbootdemo3.Repositories;

import com.example.springbootdemo3.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer>{

}

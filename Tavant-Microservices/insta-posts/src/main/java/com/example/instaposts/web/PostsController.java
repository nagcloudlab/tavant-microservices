package com.example.instaposts.web;

import com.example.instaposts.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class PostsController {

    @GetMapping("/posts")
    public List<Post> get(){

        return Arrays.asList(
          new Post(1,"post-1"),
          new Post(2,"post-2")
        );
    }

}

package com.example.instagraph.web;

import com.example.instagraph.model.Post;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

@RestController
public class GraphController {

    @GetMapping(value = "/user-posts")
    public List<Post> get() {


        // How to make REST call from here ?

        //way-1 : Rest Template

//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<Post[]> response = restTemplate.getForEntity("http://localhost:8080/posts", Post[].class);

        //way-2 : Web Client ( sync or async call )
       Post[] posts=WebClient.builder()
               .build()
               .get()
               .uri("http://localhost:8080/posts")
               .retrieve()
               .bodyToMono(Post[].class)
               .block();


        return Arrays.asList(posts);
    }

}

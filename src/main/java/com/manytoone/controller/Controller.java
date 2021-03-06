package com.manytoone.controller;

import com.manytoone.model.Post;
import com.manytoone.service.ResourceNotFoundException;
import com.manytoone.service.ServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private ServiceClass service;

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post)
    {
        return service.addPost(post);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable long id){
        return service.getPostById(id);
    }

    @GetMapping("/findAll")
    public List<Post> getAllPosts(){
        return service.getAllPosts();
    }

    @PostMapping("deleteById/{id}")
    public void deletePostById(@PathVariable long id) throws ResourceNotFoundException {
        service.deletePostById(id);
    }

    @PostMapping("/updatePostById/{id}")
    public Post updatePostById(@RequestBody Post post,@PathVariable long id){
        return service.updatePostById(post,id);
    }
}

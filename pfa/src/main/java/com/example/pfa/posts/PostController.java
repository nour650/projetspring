package com.example.pfa.posts;


import com.example.pfa.roles.Role;
import com.example.pfa.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class PostController {
    private final PostService postService;
    private RoleService roleService;
    @Autowired
    public PostController(PostService postService , RoleService roleService) {

        this.postService = postService;
        this.roleService=roleService;
    }
    @PostMapping("posts/roles/{id}")
    public Post addPost(@RequestBody Post post , @PathVariable Long id){
        Role role = roleService.getRole(id);
        post.setRole(role);
        postService.addPost(post);
        return post ;
    }
    @GetMapping("posts/")
    public List<Post> getPosts(){
        return postService.getPosts();
    }
    @GetMapping("posts/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.getPost(id);
    }
    @DeleteMapping("posts/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
    @PatchMapping("posts/{id}")
    public void updatePost(@PathVariable("id") Long id , @RequestBody Post post){
        postService.updatePost(id,post);
    }
}

package com.example.pfa.posts;
import com.example.pfa.roles.Role;

import javax.persistence.*;

@Entity(name = "Posts")
@Table (name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String description;


    @ManyToOne
    private Role role;



    public Post(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}

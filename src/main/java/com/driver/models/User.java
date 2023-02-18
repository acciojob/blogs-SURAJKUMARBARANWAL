package com.driver.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    private String firstName="test";
    private String lastName="test";

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog> writtenBlogsList;

}
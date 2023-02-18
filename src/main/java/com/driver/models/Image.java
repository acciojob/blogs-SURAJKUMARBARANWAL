package com.driver.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String dimension;

    //BLOG'S FK
    @ManyToOne
    @JoinColumn
    private Blog blog;

}
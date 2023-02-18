package com.driver.models;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public  class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    @CreationTimestamp
    private Date publishDate;

    //USER'S FK
    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image> imageList;



}
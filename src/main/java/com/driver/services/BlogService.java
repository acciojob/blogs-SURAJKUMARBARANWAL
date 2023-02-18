package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) throws Exception {
        //create a blog at the current time
        User user=userRepository.findById(userId).get();
        if(user==null) throw new Exception("User not found");
        Blog blog=new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setUser(user);
        user.getWrittenBlogsList().add(blog);
        userRepository.save(user);
        return blog;
    }

    public void deleteBlog(int blogId) throws Exception {
        //delete blog and corresponding images
        Blog blog=blogRepository.findById(blogId).get();
        if(blog==null) throw new Exception("Blog not found");
        blogRepository.deleteById(blogId);
    }
}

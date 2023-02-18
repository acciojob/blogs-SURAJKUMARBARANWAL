package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository;

    public Image addImage(Integer blogId, String description, String dimensions)  {
        //add an image to the blog
        Blog blog=blogRepository.findById(blogId).get();
        if(blog==null)return null;
        Image image=new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        image.setBlog(blog);
        blog.getImageList().add(image);
        blogRepository.save(blog);
        return image;

    }

    public void deleteImage(Integer id) {
        Image image=imageRepository.findById(id).get();
        if(image==null) return;
        imageRepository.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions){
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image=imageRepository.findById(id).get();
        if(image==null) return 0;
        String dimension=image.getDimensions();
        int length=Integer.parseInt(dimension.substring(0,1));
        int breath=Integer.parseInt(dimension.substring(2,3));
        int x= Integer.parseInt(screenDimensions.substring(0,1));
        int y= Integer.parseInt(screenDimensions.substring(2,3));
        return (x*y)/(length*breath);
    }
}

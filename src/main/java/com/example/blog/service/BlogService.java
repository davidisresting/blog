package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlogs(String title) {
        return blogRepository.findAll();
    }

    public List<Blog> getBlogsByTitle(String title) {
        return blogRepository.findByTitleContaining(title);
    }
}

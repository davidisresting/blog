package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final ModelMapper mapper;

    private BlogDto convertToDto(Blog blog) {
        return mapper.map(blog, BlogDto.class);
    }

    private Blog convertToEntity(@Valid BlogDto blogDto) {
        return mapper.map(blogDto, Blog.class);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogDto>> getBlogs(@RequestParam(required = false) String title) {
        List<Blog> blogs = blogService.getBlogs(title);
        List<BlogDto> blogDtos = blogs.stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(blogDtos, HttpStatus.OK);
//        try {
//
//
//            if (title == null)
//                blogRepository.findAll().forEach(blogs::add);
//            else
//                blogRepository.findByTitleContaining(title).forEach(blogs::add);
//            if (blogs.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(blogs, HttpStatus.OK);
//        }
//        catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
}

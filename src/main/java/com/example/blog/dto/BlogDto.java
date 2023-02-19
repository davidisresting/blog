package com.example.blog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogDto {
    private long id;

    private String title;
    private String description;
    private boolean published;
}

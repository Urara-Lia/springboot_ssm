package com.myboot.domain;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {

    private Integer id;
    private String type;
    private String name;
    private String description;
}

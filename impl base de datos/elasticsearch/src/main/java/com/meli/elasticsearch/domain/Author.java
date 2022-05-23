package com.meli.elasticsearch.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Setter
public class Author {

    @Field(type = FieldType.Text)
    private String name;

}

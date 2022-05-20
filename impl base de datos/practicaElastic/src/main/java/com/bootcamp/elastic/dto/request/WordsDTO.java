package com.bootcamp.elastic.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class WordsDTO {
    List<String> words;
}

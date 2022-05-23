package com.meli.elasticsearch.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LiteraryWorkDto implements ElasticDocumentDto {

    private final String id;
    private final String name;

    @JsonProperty("number_of_pages")
    private final int numberOfPages;

    private final String author;
    private final String editorial;

    @JsonProperty("year_of_publication")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private final LocalDate yearOfPublication;
}

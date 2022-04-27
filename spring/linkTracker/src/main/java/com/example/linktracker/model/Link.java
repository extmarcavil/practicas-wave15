package com.example.linktracker.model;

import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private int id;
    private String url;
    private int metrics;
    private String password;
    private boolean active;

    public Link(int id, String url, String password) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.metrics = 0;
        this.active = true;
    }

    public static boolean validateUrl(String url){
        final String URL_REGEX = "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";
        final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }
}

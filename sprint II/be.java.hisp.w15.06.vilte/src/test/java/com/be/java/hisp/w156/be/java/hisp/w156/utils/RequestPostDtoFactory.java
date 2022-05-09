package com.be.java.hisp.w156.be.java.hisp.w156.utils;

import com.be.java.hisp.w156.be.java.hisp.w156.dto.request.RequestPostDTO;
import com.be.java.hisp.w156.be.java.hisp.w156.model.Product;

import java.time.LocalDate;

public class RequestPostDtoFactory {

    private static final String INVALID_NAME = "&(-.¿|43";

    private static Product getProduct() {
        return new Product(1, "Silla Gamer", "Gamer", "Racer", "Red Black",
                "Special Edition");
    }

    public static RequestPostDTO validRequestPostDTO() {
        return new RequestPostDTO(1, LocalDate.of(2022, 12, 12), getProduct(), "Something", 100D);
    }

    public static RequestPostDTO aRequestPostWithNegativeId() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setUser_id(-1);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithIdNull() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setUser_id(null);

        return requestPostDTO;
    }

    public static String aRequestPostWithInvalidDateFormat() {
        return
            "{" +
                    "\"user_id\":1," +
                    "\"date\":\"2022-05-06\"," +
                    "\"detail\":{" +
                        "\"product_id\":1," +
                        "\"product_name\":\"Silla Gamer\"," +
                        "\"type\":\"Gamer\"," +
                        "\"brand\":\"Racer\"," +
                        "\"color\":\"Red & Black\"," +
                        "\"notes\":\"Special Edition\"" +
                    "}," +
                    "\"category\":\"Something\"," +
                    "\"price\":100.0" +
            "}";
    }

    public static RequestPostDTO aRequestPostWithDateNull() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setDate(null);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithPreviousDate() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setDate(LocalDate.now().minusDays(1));

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithCategoryEmpty() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setCategory("");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithPriceNull() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setPrice(null);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithPriceGreaterThan10000000() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setPrice(10000001d);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNull() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.setDetail(null);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithIdDetailNull() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setProduct_id(null);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithIdDetailNegative() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setProduct_id(-1);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNameEmpty() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setProduct_name("");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNameMoreThan40Characters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setProduct_name("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNameWithSpecialCharacters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setProduct_name(INVALID_NAME);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailTypeEmpty() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setType("");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailTypeWithSpecialCharacters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setType(INVALID_NAME);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailBrandEmpty() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setBrand("");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailBrandMoreThan25Characters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setBrand("aaaaaaaaaaaaaaaaaaaaaaaaaa");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailBrandWithSpecialCharacters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setBrand(INVALID_NAME);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailColorEmpty() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setColor("");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailColorMoreThan15Characters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setColor("aaaaaaaaaaaaaaaa");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailColorWithSpecialCharacters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setColor(INVALID_NAME);

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNotesMoreThan80Characters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setNotes("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        return requestPostDTO;
    }

    public static RequestPostDTO aRequestPostWithDetailNotesWithSpecialCharacters() {
        RequestPostDTO requestPostDTO = validRequestPostDTO();
        requestPostDTO.getDetail().setNotes(INVALID_NAME);

        return requestPostDTO;
    }
}

package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithPromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}

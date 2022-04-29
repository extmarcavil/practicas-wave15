package com.sprint.be_java_hisp_w15_g10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountPromoProductsOfUserDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private int promoProductosCount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPromoProductosCount() {
        return promoProductosCount;
    }

    public void setPromoProductosCount(int promoProductosCount) {
        this.promoProductosCount = promoProductosCount;
    }
}

package com.company;

public class Item {
    private String code;
    private String name;
    private Integer amount;
    private Integer priceByUnit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPriceByUnit() {
        return priceByUnit;
    }

    public void setPriceByUnit(Integer priceByUnit) {
        this.priceByUnit = priceByUnit;
    }
}

package com.edadpersona.edaddeunapersona.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeDto {
    Integer age;

    public  AgeDto ( Integer age){
        this.age = age;
    }

}

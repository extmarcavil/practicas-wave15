package com.example.numerosromanos.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanos {
    @GetMapping("/convert/{number}")
    public String convert(@PathVariable int number){
        String toRet = "";
        String description = "Numero original: " + number + "\n";
        int mil = number / 1000;

        if(mil > 0) description += "\nMil = " + mil + " => ";


        for (int i = number; i > 999;i-=1000){
            toRet+="M";
            number-=1000;
        }
        description+= toRet;

        int centena = number / 100;
        if(centena>0) description += "\nCentena = " + centena + " => ";

        switch (centena){
            case 1: toRet +="C";description+=" C "; number-=100; break;
            case 2: toRet +="CC";description+=" CC ";number-=200; break;
            case 3: toRet +="CCC";description+=" CCC ";number-=300; break;
            case 4: toRet +="CD";description+=" CD ";number-=400; break;
            case 5: toRet +="D";description+=" D ";number-=500; break;
            case 6: toRet +="DC";description+=" DC ";number-=600; break;
            case 7: toRet +="DCC";description+=" DCC ";number-=700; break;
            case 8: toRet +="DCCC";description+=" DCCC ";number-=800; break;
            case 9: toRet +="CM";description+=" CM ";number-=900; break;
        }

        int decena = number / 10;
        if(decena>0) description += "\nDecena = " + decena + " => ";

        switch (decena){
            case 1: toRet +="X";description += " X ";number-=10; break;
            case 2: toRet +="XX";description += " XX "; number-=20;break;
            case 3: toRet +="XXX";description += " XXX "; number-=30;break;
            case 4: toRet +="XL";description += " XL "; number-=40;break;
            case 5: toRet +="L";description += " L "; number-=50;break;
            case 6: toRet +="LX";description += " LX "; number-=60;break;
            case 7: toRet +="LXX";description += " LXX "; number-=70;break;
            case 8: toRet +="LXXX";description += " LXXX "; number-=80;break;
            case 9: toRet +="XM";description += " XM "; number-=90;break;
        }

        if (number>0) description+="\nUnidad = " + number + " => ";
        switch (number){
            case 1: toRet +="I";description += " I"; break;
            case 2: toRet +="II";description += " II";break;
            case 3: toRet +="III";description += " III";break;
            case 4: toRet +="IV";description += " IV";break;
            case 5: toRet +="V";description += " V";break;
            case 6: toRet +="VI";description += " VI";break;
            case 7: toRet +="VII";description += " VII";break;
            case 8: toRet +="VIII";description += " VIII";break;
            case 9: toRet +="IX";description += " IX";break;
        }
        
        return toRet + "\n\n" + description;
    }
}

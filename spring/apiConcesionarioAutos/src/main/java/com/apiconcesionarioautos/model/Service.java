package com.apiconcesionarioautos.model;
import java.util.Date;

public class Service {
    public Date date;
    public double kilometers;
    public String descriptions;

    //region Constructor

    public Service() {
    }

    public Service(Date date, double kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

    //endregion

    //region getters setters

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getKilometers() {
        return kilometers;
    }

    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    //endregion

}

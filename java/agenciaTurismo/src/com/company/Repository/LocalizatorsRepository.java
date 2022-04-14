package com.company.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocalizatorsRepository {
    private List<ArrayList<HashMap>> localizators;

    public void showLocalizators(){
        System.out.println(localizators);
    }

    public List<ArrayList<HashMap>> getLocalizators() {
        return localizators;
    }

    public void setLocalizators(List<ArrayList<HashMap>> localizators) {
        this.localizators = localizators;
    }

    public LocalizatorsRepository() {
    }

    @Override
    public String toString() {
        return "LocalizatorsRepository{" +
                "localizators=" + localizators +
                '}';
    }
}

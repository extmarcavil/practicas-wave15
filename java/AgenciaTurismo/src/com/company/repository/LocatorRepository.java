package com.company.repository;

import com.company.entity.Booking;
import com.company.entity.Client;
import com.company.entity.Locator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LocatorRepository {
    private Map<Integer, Locator> locators;

    public LocatorRepository(Map<Integer, Locator> locators) {
        this.locators = locators;
    }

    public Map<Integer, Locator> getLocators() {
        return this.locators;
    }


    public Integer getCountLocators() {
        return this.locators.size();
    }

    public void addLocator(Locator locator) {
        this.locators.put(locator.getId(), locator);
    }

    public List<Locator> getLocatorsByClient(Client client) {
        return this.locators
                .values()
                .stream()
                .filter(locator -> locator.getClient().equals(client))
                .collect(Collectors.toList());
    }


}

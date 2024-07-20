package com.sus.farmcollection.model;

/**
 * This class maintains the crop information of a farm.
 */
public class Crop {

    private String name;
    private String expectedAmountInTons;
    private String actualHarvestedAmountInTons;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpectedAmountInTons() {
        return expectedAmountInTons;
    }

    public void setExpectedAmountInTons(String expectedAmountInTons) {
        this.expectedAmountInTons = expectedAmountInTons;
    }

    public String getActualHarvestedAmountInTons() {
        return actualHarvestedAmountInTons;
    }

    public void setActualHarvestedAmountInTons(String actualHarvestedAmountInTons) {
        this.actualHarvestedAmountInTons = actualHarvestedAmountInTons;
    }

}

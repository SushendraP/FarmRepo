package com.sus.farmcollection.model;

import java.util.List;

/**
 * This class maintains the Farm information which needs to be maintained in
 * organisation.
 */
public class Farm {

    private String name;
    private String areaOfPlantationInAcres;
    private String season;
    private List<Crop> crops;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaOfPlantationInAcres() {
        return areaOfPlantationInAcres;
    }

    public void setAreaOfPlantationInAcres(String areaOfPlantationInAcres) {
        this.areaOfPlantationInAcres = areaOfPlantationInAcres;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<Crop> getCrops() {
        return crops;
    }

    public void setCrops(List<Crop> crops) {
        this.crops = crops;
    }


}

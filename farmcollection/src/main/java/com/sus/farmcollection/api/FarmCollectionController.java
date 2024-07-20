package com.sus.farmcollection.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sus.farmcollection.model.Farm;
import com.sus.farmcollection.model.FarmSuccessResponse;
import com.sus.farmcollection.service.FarmCollectionService;

/**
 * This controller exposes all api endpoint's required for Farm collection .
 */
@RestController
@RequestMapping("/api/farm")
public class FarmCollectionController {

    @Autowired
    private FarmCollectionService farmCollectionService;

    /**
     * This api is responsible for consuming the Planted Farm information from the
     * Farmer.
     * 
     * @param farm , the planted farm information given by the farmer.
     * @return the farm success response Once Successfully consumed.
     */
    @PostMapping("/planted")
    public FarmSuccessResponse postPlantedFarmInfo(@RequestBody Farm farm) {
        return farmCollectionService.savePlantedFarmInfomation(farm);
    }

    /**
     * This api is responsible for consuming the Harvested Farm information from the
     * Farmer.
     * 
     * @param farm the harvested farm information given by the farmer
     * @return the farm success response Once Successfully consumed.
     */
    @PostMapping("/harvested")
    public FarmSuccessResponse postHarvestedFarmInfo(@RequestBody Farm farm) {
        return farmCollectionService.saveHarvestedFarmInformation(farm);
    }

    /**
     * This api is responsible to retrieve all season reports of the Farms data in
     * the organization.
     * 
     * @return the list of farms data which is present in the organisation.
     */
    @GetMapping("/getAllSeasonReports")
    public List<Farm> getAllSeasonReports() {
        return farmCollectionService.retrieveFarmsForAllSeason();
    }

    /**
     * This api is responsible to retrieve all season reports of the Farms data in
     * the organization as a text.
     * 
     * @return the list of farms data which is present in the organisation.
     */
    @GetMapping("/getAllSeasonReportsAsText")
    public String getAllSeasonReportsAsaText() {
        return farmCollectionService.retrieveFarmsForAllSeasonAsaText();
    }

    /**
     * This api is responsible for retrieving the particular season report.
     * 
     * @param seasonName, the season name provided.
     * @return the list of farms data available in the organisation.
     */
    @GetMapping("/getSeasonReport/{seasonName}")
    public List<Farm> getReportForSeason(@PathVariable String seasonName) {
        return farmCollectionService.retrieveFarmsForSeason(seasonName);
    }

}

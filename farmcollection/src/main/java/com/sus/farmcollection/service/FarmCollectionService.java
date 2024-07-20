package com.sus.farmcollection.service;

import java.util.List;

import com.sus.farmcollection.model.Farm;
import com.sus.farmcollection.model.FarmSuccessResponse;

/**
 * This interface is responsible to maintain methods related to Farm information
 * posting and retrieval.
 */
public interface FarmCollectionService {

    /**
     * This method is responsible to save the planted farm information.
     * 
     * @param farm, the given Farm information.
     * @return the success response Once successfully consumed.
     */
    FarmSuccessResponse savePlantedFarmInfomation(Farm farm);

    /**
     * This method is responsible to save the Harvested farm information.
     * 
     * @param farm, the given farm information.
     * @return
     */
    FarmSuccessResponse saveHarvestedFarmInformation(Farm farm);

    /**
     * This method is responsible to retrieve Farm information for a season.
     * 
     * @param season the given season.
     * @return the list of farms available for the given season.
     */
    List<Farm> retrieveFarmsForSeason(String season);

    /**
     * This method is responsible to retrieve all Farm information.
     * 
     * @return the list of all farms information.
     */
    List<Farm> retrieveFarmsForAllSeason();


}

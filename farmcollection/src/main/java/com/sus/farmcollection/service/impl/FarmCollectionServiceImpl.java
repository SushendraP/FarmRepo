package com.sus.farmcollection.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sus.farmcollection.model.Crop;
import com.sus.farmcollection.model.Farm;
import com.sus.farmcollection.model.FarmSuccessResponse;
import com.sus.farmcollection.service.FarmCollectionService;

/**
 * This is an implementation class for @see {@link FarmCollectionService}.
 */
@Service
public class FarmCollectionServiceImpl implements FarmCollectionService {

    private static final int SUCCESS_CODE = 2000;

    /**
     * @see FarmCollectionService#savePlantedFarmInfomation(Farm).
     */
    @Override
    public FarmSuccessResponse savePlantedFarmInfomation(Farm farm) {
        // Just consuming here and returning the success response.
        FarmSuccessResponse response = new FarmSuccessResponse();
        response.setCode(SUCCESS_CODE);
        response.setMessage("Successfully posted Planted farm info");
        return response;

    }

    /**
     * @see FarmCollectionService#saveHarvestedFarmInfomation(Farm).
     */
    @Override
    public FarmSuccessResponse saveHarvestedFarmInformation(Farm farm) {
        // Just consuming here and returning the success response.
        FarmSuccessResponse response = new FarmSuccessResponse();
        response.setCode(SUCCESS_CODE);
        response.setMessage("Successfully posted Harvested farm info");
        return response;

    }

    /**
     * @see FarmCollectionService#retrieveFarmsForSeason(String).
     */
    @Override
    public List<Farm> retrieveFarmsForSeason(String season) {

        return retrieveFarmsForAllSeason()
                .stream()
                .filter(farm -> season.equalsIgnoreCase(farm.getSeason()))
                .toList();
    }

    /**
     * @see FarmCollectionService#retrieveFarmsForAllSeason().
     */
    @Override
    public List<Farm> retrieveFarmsForAllSeason() {
        return List.of(fetchFarmA(), fetchFarmB());
    }

    /**
     * @see FarmCollectionService#retrieveFarmsForAllSeasonAsaText().
     */
    @Override
    public String retrieveFarmsForAllSeasonAsaText() {

        return """

                Season      Farm      crop      Expected(Tons)       Actual(Tons)
                ----------------------------------------------------------------
                Spring      Farm-A    Corn      6                       5
                Spring      Farm-A    Potato    8                       4
                Summer      Farm-B    Mango     9                       6
                """;
    }


    /**
     * This is just a sample data for Farm-A.
     * 
     * @return Farm-A info with populated data.
     */
    private Farm fetchFarmA() {
        Farm farmA = new Farm();
        farmA.setName("Farm-A");
        farmA.setSeason("Spring");
        farmA.setAreaOfPlantationInAcres("3");
        farmA.setCrops(List.of(fetchCornCropInfo(), fetchPotatoCropInfo()));
        return farmA;

    }

    /**
     * This is just a sample data for Farm-B.
     * 
     * @return Farm-B info with populated data.
     *
     */
    private Farm fetchFarmB() {
        Farm farmB = new Farm();
        farmB.setName("Farm-B");
        farmB.setSeason("Summer");
        farmB.setAreaOfPlantationInAcres("4");
        farmB.setCrops(List.of(fetchMangoCropInfo()));
        return farmB;

    }

    /**
     * This is just a sample data for Corn crop.
     * 
     * @return Corn crop info with populated data.
     *
     */
    private Crop fetchCornCropInfo() {
        Crop cornCrop = new Crop();
        cornCrop.setName("Corn");
        cornCrop.setExpectedAmountInTons("6");
        cornCrop.setActualHarvestedAmountInTons("5");

        return cornCrop;

    }

    /**
     * This is just a sample data for Potato crop.
     * 
     * @return Potato crop info with populated data.
     *
     */
    private Crop fetchPotatoCropInfo() {
        Crop potatoCrop = new Crop();
        potatoCrop.setName("Potato");
        potatoCrop.setExpectedAmountInTons("8");
        potatoCrop.setActualHarvestedAmountInTons("4");
        return potatoCrop;

    }

    /**
     * This is just a sample data for Mango crop.
     * 
     * @return Mango crop info with populated data.
     *
     */
    private Crop fetchMangoCropInfo() {
        Crop mangoCrop = new Crop();
        mangoCrop.setName("Mango");
        mangoCrop.setExpectedAmountInTons("9");
        mangoCrop.setActualHarvestedAmountInTons("6");
        return mangoCrop;

    }


}

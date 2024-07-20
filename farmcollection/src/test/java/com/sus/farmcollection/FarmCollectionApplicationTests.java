package com.sus.farmcollection;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.sus.farmcollection.model.Farm;
import com.sus.farmcollection.model.FarmSuccessResponse;

/**
 * This is an integration test suite for all the api's. It ensures the test
 * coverage of complete api flow.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FarmCollectionApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Testing the planted info posting api")
    void testPostPlantedInfoApi() {

        Farm plantedfarm = new Farm();
        plantedfarm.setName("FarmA");
        plantedfarm.setSeason("Spring");

        EntityExchangeResult<FarmSuccessResponse> exchangeResult = webTestClient
                .post()
                .uri("/api/farm/planted")
                .bodyValue(plantedfarm)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(FarmSuccessResponse.class)
                .returnResult();

        FarmSuccessResponse farmSuccessResponse = exchangeResult.getResponseBody();
        Assertions.assertThat(farmSuccessResponse.getCode()).isEqualTo(2000);
        Assertions.assertThat(farmSuccessResponse.getMessage()).isEqualTo("Successfully posted Planted farm info");

    }

    @Test
    @DisplayName("Testing the harvested info posting api")
    void testPostHarvestedInfoApi() {

        Farm harvestedFarm = new Farm();
        harvestedFarm.setName("FarmB");
        harvestedFarm.setSeason("Summer");

        EntityExchangeResult<FarmSuccessResponse> exchangeResult = webTestClient
                .post()
                .uri("/api/farm/harvested")
                .bodyValue(harvestedFarm)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(FarmSuccessResponse.class)
                .returnResult();

        FarmSuccessResponse farmSuccessResponse = exchangeResult.getResponseBody();
        Assertions.assertThat(farmSuccessResponse.getCode()).isEqualTo(2000);
        Assertions.assertThat(farmSuccessResponse.getMessage()).isEqualTo("Successfully posted Harvested farm info");

    }

    @Test
    @DisplayName("Testing the all seasons report api")
    void testGetAllSeasonReportsApi() {

        EntityExchangeResult<List<Farm>> exchangeResult = webTestClient
                .get()
                .uri("/api/farm/getAllSeasonReports")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Farm.class)
                .returnResult();

        List<Farm> farms = exchangeResult.getResponseBody();
        Farm farmA = farms.get(0);
        Assertions.assertThat(farmA.getName()).isEqualTo("Farm-A");
        Assertions.assertThat(farmA.getSeason()).isEqualTo("Spring");
        Assertions.assertThat(farmA.getAreaOfPlantationInAcres()).isEqualTo("3");
        Assertions.assertThat(farmA.getCrops().get(0).getName()).isEqualTo("Corn");
        Assertions.assertThat(farmA.getCrops().get(0).getExpectedAmountInTons()).isEqualTo("6");
        Assertions.assertThat(farmA.getCrops().get(0).getActualHarvestedAmountInTons()).isEqualTo("5");

        // can add more assertions as above.

    }

    @Test
    @DisplayName("Testing the all seasons report as a text api")
    void testGetAllSeasonReportsAsaTextApi() {

        EntityExchangeResult<String> exchangeResult = webTestClient
                .get()
                .uri("/api/farm/getAllSeasonReportsAsText")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .returnResult();

        String result = exchangeResult.getResponseBody();

        String expected = """

                Season      Farm      crop      Expected(Tons)       Actual(Tons)
                ----------------------------------------------------------------
                Spring      Farm-A    Corn      6                       5
                Spring      Farm-A    Potato    8                       4
                Summer      Farm-B    Mango     9                       6
                """;

        Assertions.assertThat(result).isEqualTo(expected);


    }

    @Test
    @DisplayName("Testing the particular season report api")
    void testgetReportForSeasonApi() {

        EntityExchangeResult<List<Farm>> exchangeResult = webTestClient
                .get()
                .uri("/api/farm/getSeasonReport/Spring")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Farm.class)
                .returnResult();

        List<Farm> farms = exchangeResult.getResponseBody();
        Farm farmA = farms.get(0);
        Assertions.assertThat(farmA.getName()).isEqualTo("Farm-A");
        Assertions.assertThat(farmA.getSeason()).isEqualTo("Spring");
        Assertions.assertThat(farmA.getAreaOfPlantationInAcres()).isEqualTo("3");
        Assertions.assertThat(farmA.getCrops().get(0).getName()).isEqualTo("Corn");
        Assertions.assertThat(farmA.getCrops().get(0).getExpectedAmountInTons()).isEqualTo("6");
        Assertions.assertThat(farmA.getCrops().get(0).getActualHarvestedAmountInTons()).isEqualTo("5");

    }

}

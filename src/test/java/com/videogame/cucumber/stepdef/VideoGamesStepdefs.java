package com.videogame.cucumber.stepdef;

import com.videogame.stepinfo.VideoGameSteps;
import com.videogame.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.core.IsEqual.equalTo;

public class VideoGamesStepdefs {

    static int id = 1 + TestUtils.getRandomValueInt();
    static String name ="Iron Man ";
    static String releaseDate = "2021-07-15T19:08:27.6092";
    static int reviewScore = 89;
    static String category = "Entertainment";
    static String rating = "Good";

    @Steps
    VideoGameSteps videoGameSteps;


    @When("^I create a new videogame by providing the information name\"([^\"]*)\" releaseDate\"([^\"]*)\" rating\"([^\"]*)\"$")
    public void iCreateANewVideogameByProvidingTheInformationNameReleaseDateRating(String name, String releaseDate, String rating)  {
        videoGameSteps.createNewVideoGames(id, name, releaseDate, reviewScore , category, rating).statusCode(200).log().all().extract().response()
                .body().jsonPath();

    }

    @When("^I send the Get request to videogame endpoint with ID \"([^\"]*)\",I should received the videogame information$")
    public void iSendTheGetRequestToVideogameEndpointWithIDIShouldReceivedTheVideogameInformation(String videogameid)  {
        videoGameSteps.getVideoGameById(id).statusCode(200).log().all();

    }

    @When("^I update a created videogame providing the new name category and rating$")
    public void iUpdateACreatedVideogameProvidingTheNewNameCategoryAndRating() {
        id = id ;
        name = name + "_Updated";
        releaseDate = releaseDate ;
        reviewScore =  reviewScore + 1  ;
        category = category + "_Updated";
        rating = rating + "_Updated";

        videoGameSteps.updateVideoGameById(id,name,releaseDate,reviewScore,category,rating).statusCode(200).log().all();

    }

    @Then("^I verify the videogame is updated$")
    public void iVerifyTheVideogameIsUpdated() {
        videoGameSteps.getVideoGameById(id).body("id",equalTo(id));

    }

    @When("^I delete a created videogame ,they must get back a valid status code is (\\d+)$")
    public void iDeleteACreatedVideogameTheyMustGetBackAValidStatusCodeIs(int id) {
        videoGameSteps.deleteVideoGame(id).statusCode(200).log().all();
    }

    @When("^User sends a GET request to videogames endpoint, they must get back a valid status code 200$")
    public void userSendsAGETRequestToVideogamesEndpointTheyMustGetBackAValidStatusCode() {
        videoGameSteps.getAllVideoGameFromList().log().all().statusCode(200);
    }
}



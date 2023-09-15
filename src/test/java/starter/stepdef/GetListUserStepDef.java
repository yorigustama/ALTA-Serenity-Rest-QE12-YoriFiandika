package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetListUser;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetListUserStepDef {
    @Steps
    GetListUser getListUser;
    @Given("Get list user with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        getListUser.setGetListUser(page);
    }

    @When("Send request get list")
    public void sendRequestGetList() {
        SerenityRest.when().get(GetListUser.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Respon body page should be {}")
    public void responBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }
    @And("Respon id page body page should be {}")
    public void responIdPageBodyPageShouldBe(String page) {
        SerenityRest.and().body(ReqresResponses.DATA_ID_ARRAY,equalTo(page));
    }
    @And("Validate get list user JSON schema {string}")
    public void validateGetListUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //invalid
    @Given("Get list user with invalid parameter page {int}")
    public void getListUserWithInvalidParameterPage(int page) {
        getListUser.setGetListUser(page);
    }
    @Then("Status code should be {int} not found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }




    //Negatif


}

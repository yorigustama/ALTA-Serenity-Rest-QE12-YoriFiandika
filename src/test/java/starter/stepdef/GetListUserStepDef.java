package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetListUser;

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

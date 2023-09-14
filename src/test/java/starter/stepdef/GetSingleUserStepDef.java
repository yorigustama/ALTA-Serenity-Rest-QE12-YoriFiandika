package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.GetSingleUser;
import starter.utils.Constants;

import java.io.File;

public class GetSingleUserStepDef {
    @Steps
    GetSingleUser getSingleUser;

    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterId(int id) {
        getSingleUser.setGetSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetSingleUser.GET_SINGLE_USER);
    }

    @Given("Get single user with invalid parameter id {int}")
    public void getSingleUserWithInvalidParameterId(int id) {
        getSingleUser.setGetSingleUser(id);
    }
}

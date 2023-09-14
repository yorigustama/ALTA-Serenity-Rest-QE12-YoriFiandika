package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import starter.reqres.PostCreateUser;
import starter.utils.Constants;

import java.io.File;


public class PostCreateUserStepDef {

    @Steps
    PostCreateUser postCreateUser;
    @Given("Create new user with valid json {string}")
    public void createNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTCREATEUSER+jsonFile);
        postCreateUser.setPostCrateNewUser(json);

    }

    @When("Send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(PostCreateUser.POST_CRATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }
}

package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import starter.reqres.PostCreateUser;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;
import static org.hamcrest.Matchers.equalTo;

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

    @And("Validate post create user JSON schema {string}")
    public void validatePostCreateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Status code should be {int} bad request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }


    @And("Validate post create JSON schema {string}")
    public void validatePostCreateJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}

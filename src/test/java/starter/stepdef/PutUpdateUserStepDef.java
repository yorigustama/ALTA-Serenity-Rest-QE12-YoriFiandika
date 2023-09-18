package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PutUpdateUser;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateUserStepDef {
    @Steps
    PutUpdateUser putUpdateUser;
    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PUTUPDATEUSER+jsonFile);
        putUpdateUser.setPutUpdateUser(json, id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(PutUpdateUser.PUT_UPDATE_USER);
    }
    @And("Validate put update user JSON schema {string}")
    public void validatePutUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("Respon body name was {string} and job was {string}")
    public void responBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name));
        SerenityRest.and().body(ReqresResponses.JOB,equalTo(job));
    }


    @Given("Update user with invalid json {string} and user id {int}")
    public void updateUserWithInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PUTUPDATEUSER+jsonFile);
        putUpdateUser.setPutUpdateUser(json, id);
    }


}

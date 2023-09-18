package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PatchUpdateUser;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class PatchUpdateUserStepDef {

    @Steps
    PatchUpdateUser patchUpdateUser;


    @Given("Update user patch with valid json {string} and user id {int}")
    public void updateUserPatchWithValidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PATCHUPDATEUSER + jsonFile);
        patchUpdateUser.setPatchUpdateUser(json, id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(PatchUpdateUser.PATCH_UPDATE_USER);
    }
    @And("Respon body patch name was {string} and job was {string}")
    public void responBodyPatchNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name));
        SerenityRest.and().body(ReqresResponses.JOB,equalTo(job));
    }


    @Given("Update user patch without job field invalid json {string} and user id {int}")
    public void updateUserPatchWithoutJobFieldInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PATCHUPDATEUSER + jsonFile);
        patchUpdateUser.setPatchUpdateUser(json, id);
    }
    @And("Respon body patch update without job was {string}")
    public void responBodyPatchUpdateWithoutJobWas(String name) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name));
    }

    @Given("Update user patch without name field invalid json {string} and user id {int}")
    public void updateUserPatchWithoutNameFieldInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PATCHUPDATEUSER + jsonFile);
        patchUpdateUser.setPatchUpdateUser(json, id);
    }

    @And("Validate patch update user JSON schema {string}")
    public void validatePatchUpdateUserJSONSchema(String jsonFile) {
        File json = new File(Constants.JSON_SCHEMA+jsonFile);
        SerenityRest
                .and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Respon body patch update without name was {string}")
    public void responBodyPatchUpdateWithoutNameWas(String job) {
        SerenityRest.and().body(ReqresResponses.JOB,equalTo(job));
    }
}



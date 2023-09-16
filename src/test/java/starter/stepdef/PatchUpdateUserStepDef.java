package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PatchUpdateUser;
import starter.utils.Constants;

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

    @Given("Update user patch without job field invalid json {string} and user id {int}")
    public void updateUserPatchWithoutJobFieldInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PATCHUPDATEUSER + jsonFile);
        patchUpdateUser.setPatchUpdateUser(json, id);
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
}



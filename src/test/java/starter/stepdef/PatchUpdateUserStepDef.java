package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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

}



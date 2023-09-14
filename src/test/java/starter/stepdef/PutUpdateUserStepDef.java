package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PutUpdateUser;
import starter.utils.Constants;

import java.io.File;

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



    @Given("Update user with invalid json {string} and user id {int}")
    public void updateUserWithInvalidJsonAndUserId(String jsonFile, int id) {
        File json = new File(Constants.REQ_BODY_PUTUPDATEUSER+jsonFile);
        putUpdateUser.setPutUpdateUser(json, id);
    }
}

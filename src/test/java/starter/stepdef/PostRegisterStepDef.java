package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostRegister;
import starter.utils.Constants;

import java.io.File;

public class PostRegisterStepDef {
    @Steps
    PostRegister postRegister;

    @Given("Create register new user with valid json {string}")
    public void createRegisterNewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTREGISTER+jsonFile);
        postRegister.setPostRegister(json);
    }

    @When("Send request post register create new user")
    public void sendRequestPostRegisterCreateNewUser() {
        SerenityRest.when().post(PostRegister.POST_REGISTER);
    }

    @Given("Create register new user with invalid json {string}")
    public void createRegisterNewUserWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTREGISTER+jsonFile);
        postRegister.setPostRegister(json);
    }


}

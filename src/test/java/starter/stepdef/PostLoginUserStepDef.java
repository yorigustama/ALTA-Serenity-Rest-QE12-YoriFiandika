package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.PostLoginUser;
import starter.utils.Constants;

import java.io.File;

public class PostLoginUserStepDef {
    @Steps
    PostLoginUser postLoginUser;
    @Given("Login a new user with valid json {string}")
    public void loginANewUserWithValidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTLOGINUSER+jsonFile);
        postLoginUser.setPostLogin(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(PostLoginUser.POST_LOGIN);
    }

    @Given("Login a new user without password invalid json {string}")
    public void loginANewUserWithInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTLOGINUSER+jsonFile);
        postLoginUser.setPostLogin(json);
    }

    @Given("Login a new user without email invalid json {string}")
    public void loginANewUserWithoutEmailInvalidJson(String jsonFile) {
        File json = new File(Constants.REQ_BODY_POSTLOGINUSER+jsonFile);
        postLoginUser.setPostLogin(json);
    }
}

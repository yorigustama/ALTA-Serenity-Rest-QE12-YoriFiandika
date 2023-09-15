package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.DeleteUser;

public class DeleteUserStepDef {
    @Steps
    DeleteUser deleteUser;
    @Given("Delete a user with valid user id {int}")
    public void deleteAUserWithValidUserId(int id) {
        deleteUser.setDeleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(DeleteUser.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("Delete a user with invalid user id {int}")
    public void deleteAUserWithInvalidUserId(int id) {
        deleteUser.setDeleteUser(id);
    }
}

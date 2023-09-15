package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PatchUpdateUser {
    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";
    @Step("Patch update user")
    public void setPatchUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}

package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class PostCreateUser {
    public static String POST_CRATE_USER = Constants.BASE_URL+"/api/users";
    @Step("Post create new user")
    public void setPostCrateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}

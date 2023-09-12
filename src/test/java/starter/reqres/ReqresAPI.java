package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {

    public static String GET_LIST_USER = Constants.BASE_URL+"/api/users?page={page}";
    public static String POST_CRATE_USER = Constants.BASE_URL+"/api/users";

    @Step("Get list user")
    public void setGetListUser(int page){
        SerenityRest.given()
                .pathParam("page", page);

    }
    @Step("Post create new user")
    public void setPostCrateNewUser(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }




}

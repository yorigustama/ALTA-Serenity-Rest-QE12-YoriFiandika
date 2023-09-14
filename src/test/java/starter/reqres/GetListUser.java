package starter.reqres;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

public class GetListUser {
    public static String GET_LIST_USER = Constants.BASE_URL+"/api/users?page={page}";
    @Step("Get list user")
    public void setGetListUser(int page){
        SerenityRest.given()
                .pathParam("page", page);

    }

}

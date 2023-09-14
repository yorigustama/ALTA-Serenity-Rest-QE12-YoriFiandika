package starter.utils;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class Constants {

    public static final String BASE_URL = "https://reqres.in";

    public static String DIR = System.getProperty("user.dir");
    public static String JSON = DIR+"/src/test/resources/JSON";
    public static String REQ_BODY_POSTCREATEUSER = JSON+"/ReqBody/PostCreateUser/";
    public static String REQ_BODY_PUTUPDATEUSER = JSON+"/ReqBody/PutUpdateUser/";

}

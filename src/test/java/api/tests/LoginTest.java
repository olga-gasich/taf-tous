package api.tests;

import api.LoginPageObject;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoginTest {

    @Test
    public void testLoginWithEmptyEmailAndPassword(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithEmptyEmailAndInvalidPassword(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("", "12345");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndEmptyPassword(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("o.test@gmail.com", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("o.test@gmail.com", "Pwd1122334455");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithValidEmailAndEmptyPassword(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("olagasich@gmail.com", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithValidCredentials(){

        LoginPageObject object = new LoginPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("olagasich@gmail.com", "Pwd1122334455");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("access_token")).
                assertThat().body(containsString("refresh_token"));
    }
}

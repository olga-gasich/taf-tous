package api.tests;

import api.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    public void testLoginWithEmptyEmailAndPassword() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("error", equalTo("invalid_grant")).body("error_description", equalTo("Bad credentials"));
    }

    @Test
    public void testLoginWithEmptyEmailAndInvalidPassword() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("", "12345");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("error", equalTo("invalid_grant")).body("error_description", equalTo("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndEmptyPassword() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("test@gmail.com", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("error", equalTo("invalid_grant")).body("error_description", equalTo("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("test@gmail.com", "Pwd1122334455");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("error", equalTo("invalid_grant")).body("error_description", equalTo("Bad credentials"));
    }

    @Test
    public void testLoginWithValidEmailAndEmptyPassword() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("olagasich@gmail.com", "");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("error", equalTo("invalid_grant")).body("error_description", equalTo("Bad credentials"));
    }

    @Test
    public void testLoginWithValidCredentials() {

        LoginPage object = new LoginPage();
        HashMap<String, String> queryParams = object.getQueryParams("olagasich@gmail.com", "Pwd1122334455");

        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat()
                .statusCode(200)
                .assertThat().body("token_type", equalTo("bearer")).body("scope", equalTo("basic openid"));
    }
}

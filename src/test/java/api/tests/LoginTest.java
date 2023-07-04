package api.tests;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoginTest {

    @Test
    public void testLoginWithEmptyEmail(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithEmptyPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("password","");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithEmptyEmailAndPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","");
        queryParams.put("password","");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithEmptyEmailAndInvalidPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","");
        queryParams.put("password","12345");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndEmptyPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","o.test@gmail.com");
        queryParams.put("password","");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithInvalidEmailAndValidPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","o.test@gmail.com");
        queryParams.put("password","Pwd1122334455");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithValidEmailAndEmptyPassword(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","olagasich@gmail.com");
        queryParams.put("password","");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("invalid_grant")).
                assertThat().body(containsString("Bad credentials"));
    }

    @Test
    public void testLoginWithValidCredentials(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username","olagasich@gmail.com");
        queryParams.put("password","Pwd1122334455");
        given().when().queryParams(queryParams).post("https://www.tous.com/authorizationserver/oauth/token")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("access_token")).
                assertThat().body(containsString("refresh_token"));
    }
}

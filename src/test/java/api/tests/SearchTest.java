package api.tests;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchTest {

    @Test
    public void testSearchForRings(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","anillos");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("Anillo"));
    }

    @Test
    public void testSearchForRingsAndBracelets(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","anillos+y+pulseras");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("Pulsera"));
    }

    @Test
    public void testSearchForSpecificBag(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","Saca+mediana+blanco+y+negro");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("Saca mediana blanco y negro"));
    }

    @Test
    public void testSearchForInvalidData(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","1q@#$%^&*()_+=");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(not(containsString("1q@#$%^&*()_+=")));
    }

    @Test
    public void testSearchForNotExistingItem(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","sofa Ikea");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(not(containsString("sofa Ikea")));
    }

    @Test
    public void testSearchWithEmptyData(){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope","desktop");
        queryParams.put("lang","es");
        queryParams.put("store","es");
        queryParams.put("session","493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows","24");
        queryParams.put("start","0");
        queryParams.put("origin","default");
        queryParams.put("q","");
        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("q is mandatory"));
    }
}

package api.tests;

import api.SearchPageObject;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchTest {

    @Test
    public void testSearchForRings(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("anillos");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("Anillo"));
    }

    @Test
    public void testSearchForRingsAndBracelets(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("anillos+y+pulseras");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(containsString("Pulsera"));
    }

    @Test
    public void testSearchForSpecificBag(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("Saca+mediana+blanco+y+negro");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body("content.docs[0].name",equalTo("Saca mediana blanco y negro TOUS Cloud Soft")).
                assertThat().body("content.numFound",equalTo(1));
    }

    @Test
    public void testSearchForInvalidData(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("1q@#$%^&*()_+=");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(not(containsString("1q@#$%^&*()_+=")));
    }

    @Test
    public void testSearchForNotExistingItem(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("sofa Ikea");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200).
                assertThat().body(not(containsString("sofa Ikea"))).
                assertThat().body("content.numFound",equalTo(0));
    }

    @Test
    public void testSearchWithEmptyData(){

        SearchPageObject object = new SearchPageObject();
        HashMap<String, String> queryParams = object.getQueryParams("");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(400).
                assertThat().body(containsString("q is mandatory"));
    }
}

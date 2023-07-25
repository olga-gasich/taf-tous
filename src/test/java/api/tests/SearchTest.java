package api.tests;

import api.SearchPage;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchTest {

    @Test
    public void testSearchForRings() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("anillos");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat()
                .statusCode(200)
                .body("content.docs[0].name", equalTo("Anillo bicolor Virtual Garden"));
    }

    @Test
    public void testSearchForRingsAndBracelets() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("anillos+y+pulseras");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat()
                .statusCode(200)
                .body("content.docs[0].name", equalTo("Pulsera de perlas y oro Hold"));
    }

    @Test
    public void testSearchForSpecificBag() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("Saca+mediana+blanco+y+negro");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat().statusCode(200)
                .assertThat().body("content.docs[0].name", equalTo("Saca mediana blanco y negro TOUS Cloud Soft"))
                .assertThat().body("content.numFound", equalTo(1));
    }

    @Test
    public void testSearchForInvalidData() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("1q@#$%^&*()_+=");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat()
                .statusCode(200)
                .assertThat().body("content.numFound", equalTo(0));
    }

    @Test
    public void testSearchForNotExistingItem() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("table Ikea");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat()
                .statusCode(200)
                .assertThat().body("content.numFound", equalTo(0));
    }

    @Test
    public void testSearchWithEmptyData() {

        SearchPage object = new SearchPage();
        HashMap<String, String> queryParams = object.getQueryParams("");

        given().when().queryParams(queryParams).get("https://api.empathybroker.com/search/v1/query/tous/searchX")
                .then().assertThat()
                .statusCode(400)
                .assertThat().body("code", equalTo(400)).body("error", equalTo("q is mandatory"));
    }
}

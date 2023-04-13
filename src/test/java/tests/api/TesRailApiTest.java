package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TesRailApiTest extends BaseApiTest {
 @Test
    public void getProjects(){
     String endpoint = "index.php?/api/v2/get_projects";
     given()
             .when()
             .get(endpoint)
             .then()
             .log().body()
             .statusCode(HttpStatus.SC_OK);
 }
 @Test
    public void getAllUsersDetails(){

 }

}

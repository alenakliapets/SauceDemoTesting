package tests.api;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestrailSimpleApiTest {

    @Test
    public void getProjects(){
        RestAssured.baseURI = ReadProperties.getInstance().getTestrailURL();
        String endpoint = "index.php?/api/v2/get_projects";
        //Настройка Request
        RequestSpecification httpsRequest = given();

        httpsRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);

        httpsRequest.auth().preemptive()
                .basic(ReadProperties.getInstance().getApiUsername(),
                        ReadProperties.getInstance().getApiPassword());

        //Настройка Response
        Response response = httpsRequest.request(Method.GET, endpoint);

        //Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        //Get Response Status
        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }
}

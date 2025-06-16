package Day2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;


public class PathAndQueryParam {


    @Test
    void pathParams() {

        given()
                .relaxedHTTPSValidation()
                .pathParam("mypath","users") // path params


                .when()
                .get("https://reqres.in/api/{mypath}")
                .then()
                .statusCode(200)
                .log().all();


    }














}

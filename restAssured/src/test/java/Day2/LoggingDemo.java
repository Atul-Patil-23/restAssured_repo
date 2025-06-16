package Day2;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoggingDemo {

    @Test
    void testLogs()
    {
        given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                //.log().body();
                //.log().cookies();
                //.log().headers();
                .log().all();
    }













}

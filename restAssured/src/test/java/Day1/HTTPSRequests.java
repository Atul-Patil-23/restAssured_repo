package Day1;

/*
given ()
 content type, set cookies, add auth, add param, set headers info  etc..

when()
  get post put delete

then()
  validate status code, extract response, extract headers cookies & response body  etc...


 */

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.* ;




public class HTTPSRequests {

    @Test
    void getUsers()
    {
        given()
                .relaxedHTTPSValidation()
                .when()
                .get("https://reqres.in/api/users?page=2")

                .then()
                    .statusCode(200)
                    .body("page", equalTo(2))
                    .log().all();

    }
}

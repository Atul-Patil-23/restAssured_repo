package Day6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.equalTo;

public class Authentications {

    private static final Logger log = LoggerFactory.getLogger(Authentications.class);

    // Basic. Digest and preemptive authentication types are almost same
    @Test
    void testBasicAuth() {

        // This is basic auth

        given()
                .auth().basic("postman", "password")
                .when()
                .get("Postman URL")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test
    void testDigestAuth() {

        // This is digest auth

        given()
                .auth().digest("postman", "password")
                .when()
                .get("Postman URL")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test
    void testPreemptiveAuth() {

        // This is preemptive auth

        given()
                .auth().preemptive().basic("postman", "password")
                .when()
                .get("Postman URL")
                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
                .log().all();

    }

    @Test(priority = 1)
    void bearerTokenAuth() {
        // This authenticator is passed along with header
        String bearerToken = "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";
        given()
                .headers("Authorization", "Bearer " + bearerToken)
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void testOAuth2Authentication() {
        given()
                .auth().oauth2("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")
                .when()
                .get("https://api.github.com/user/repos")
                .then()
                .statusCode(200)
                .log().all();
    }


}
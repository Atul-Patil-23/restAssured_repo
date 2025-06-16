package Day5;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.* ;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class JSONSchemaValidation {

// Here 1st convert json to json schema validator and store that file into src/test/resource folder

    @Test
    void jsonSchemaValidation()
    {
        given()
                .when()
                .get("URL of localhost")
                .then()

                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("name_of jsonSchema_File"));

    }




}

package Day3;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.* ;

import static io.restassured.RestAssured.*;

public class ParsingJSONResponseData {

  //  @Test
    void testJSONResponse() {
        // Approach 1
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://localhost:3000/store")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                // to find the title, user json path finder
                .body("book[3].title", equalTo("The lord"));

        // Approach 2
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://localhost:3000/store");
        Assert.assertEquals(res.getStatusCode(), 200);
        Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");

        String bookname = res.jsonPath().get("book[3].title").toString();
        Assert.assertEquals(bookname, "The lord");

    }
        @Test()
        void testJSONResponseBodyData()
        {

            Response res = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get("https://localhost:3000/store");

            //using JSON object class
            JSONObject jsonObject=new JSONObject(res.asString());

            // Print all title of books
            /*for(int i=0; i<jsonObject.getJSONArray("book").length(); i++)
            {
                String bookTitle=jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();
                System.out.println(bookTitle);


            }*/

            boolean status=false;
            for(int i=0; i<jsonObject.getJSONArray("book").length(); i++)
            {
                String bookTitle=jsonObject.getJSONArray("book").getJSONObject(i).get("title").toString();

                if(bookTitle.equals("The lord"))
                {
                    status=true;
                    break;
                }


            }
            Assert.assertEquals(status,true);
        }






    }






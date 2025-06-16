package Day2;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HeadersDemo {

  //  @Test(priority = 1)
    void testHeader()
    {
        given()
                .when()
                .get("https://www.google.com")
                .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws");

    }

    @Test(priority = 2)
void getHeader()
    {

        Response response =  given()
                .when()
                .get("https://www.google.com");

        // get single header info
       String headervalue= response.getHeader("Content-Type");
       System.out.println("header value:"+headervalue);

       // get all headers info
        Headers myheader=response.getHeaders();
        for(Header hd:myheader)
        {
            System.out.println(hd.getName()+"    " +hd.getValue());

        }
    }








}

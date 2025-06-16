package Day4;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.* ;

import static io.restassured.RestAssured.*;

public class ParsingXMLResponse {

    @Test
    void testXMLResponse()
    {
        //Approach 1
      /*  given()
                .when()
                .get("https://restapi.adequateshop.com/Traveler?page=1")
                .then()
                .statusCode(200)
                .header("Content-Type","application/xml; charset=utf-8")
                .body("TravelerInformationResponse.travelers.TravelerInformation[0].name",equalTo("Atul Patil"));

       */
        // Approach 2
       Response response= given()
                .when()
                .get("https://restapi.adequateshop.com/Traveler?page=1");
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.header("Content-Type"),"application/xml; charset=utf-8");
        String pageNo= response.xmlPath().get("TravelerInformationResponse.page").toString();
        Assert.assertEquals(pageNo,"1");
        String travelName=response.xmlPath().get("TravelerInformationResponse.travelers.TravelerInformation[0].name").toString();
        Assert.assertEquals(travelName,"Atul Patil");






    }

    @Test(priority = 1)
    void testXMLResponseBody()
    {
        // Store XML response body into variable and done some validation

        Response response=given()
                .when()
                .get("https://restapi.adequateshop.com/Traveler?page=1");

        //create an object of xml path
        XmlPath xmlobj= new XmlPath(response.asString());

        //verify total number of travellers
        List<String> travellers= xmlobj.getList("TravelerInformationResponse.travelers.TravelerInformation");
        Assert.assertEquals(travellers.size(),10);

        //verify traveller name is present in response
        List<String> travellers_name= xmlobj.getList("TravelerInformationResponse.travelers.TravelerInformation.name");
        boolean status=false;
        for(String name:travellers_name)
        {
            if(name.equals("Atul Patil"))
            {
                status=true;
                break;
            }
        }

Assert.assertEquals(status,true);


    }




}

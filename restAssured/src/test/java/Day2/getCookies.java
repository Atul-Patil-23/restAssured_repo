package Day2;

import com.github.scribejava.core.model.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getCookies {

   // @Test(priority = 1)
    void cookies()
    {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .cookie("NID","524%3DZ3yU1_5ClPDwCmXSvsg09_P_r2kNF3BI8EF9rhglt3gEiQ6CCvT-U2oeBfoq_nDOwvATQCliduUF6GP5iNjIBGNCZ_mIIb-pK-INwHLuzUg-P3JVvEmZH5zS_3sldH-v0pj9YwKCwZXtlkHm4AFGa9xpns75h-pmH2-l2X1zGrEeViAuSyAJFVZ84gLg9yJlmyNmL81b_dQSENzRl_Q")
                .log().all();
    }







}

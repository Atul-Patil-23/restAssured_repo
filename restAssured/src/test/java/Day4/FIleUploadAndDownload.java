package Day4;

import groovy.xml.StreamingDOMBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FIleUploadAndDownload {

    private static final Logger log = LoggerFactory.getLogger(FIleUploadAndDownload.class);

    @Test
    void singleFileUpload()
    {

        File myfile=new File("C:\\Automation\\Test.txt");
        given()
                .multiPart("file",myfile) // this si key and value form postman
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadFile")
                .then()
                .statusCode(200)
                .body("filename",equalTo("Test.txt"))
                .log().all();

    }

    @Test
    void multipleFilesUpload()
    {

        File myfile1=new File("C:\\Automation\\Test1.txt");
        File myfile2=new File("C:\\Automation\\Test2.txt");
        given()
                .multiPart("files",myfile1)
                .multiPart("files",myfile2)
                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles")
                .then()
                .statusCode(200)
                .body("[0].filename",equalTo("Test1.txt"))
                .body("[1].filename",equalTo("Test2.txt"))
                .log().all();

    }

    @Test
    void multipleFilesUploads2()  // wont work all kind of api
    {
// if we have lot number of files to upload then specify location of file as like below
        File myfile1=new File("C:\\Automation\\Test1.txt");
        File myfile2=new File("C:\\Automation\\Test2.txt");
        File myfile3=new File("C:\\Automation\\Test3.txt");
        File myfile4=new File("C:\\Automation\\Test4.txt");

        File file_arr[]={myfile1,myfile2,myfile3,myfile4};

        given()
                .multiPart("files",file_arr)  // here specify array variables

                .contentType("multipart/form-data")
                .when()
                .post("http://localhost:8080/uploadMultipleFiles")
                .then()
                .statusCode(200)
                .body("[0].filename",equalTo("Test1.txt"))
                .body("[1].filename",equalTo("Test2.txt"))
                .log().all();

    }

    @Test
    void fileDownload()
    {
        given()
                .when()
                .get("http://localhost:8080/downloadFile/Test1.txt")
                .then()
                .statusCode(200)
                .log().body();
// fil multiple file check, u have to check multiple file check status
    }

}

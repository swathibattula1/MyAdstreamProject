package com.testapi;

import java.io.IOException;

import static io.restassured.RestAssured.*;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.xml.XmlPath.from;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;

public class Getcall {

    public static void main(String[] args) throws IOException {

       /* int code=get("http://services.groupkt.com/country/get/all").statusCode();

        //get("http://services.groupkt.com/country/get/all").statusCode().log().all();
        System.out.println(code);
        Assert.assertEquals(code,200);

        String body=get("http://services.groupkt.com/country/get/all").asString();
        System.out.println(body);
*/

      /*  //To check status code
        given().get("http://services.groupkt.com/country/get/all").then().statusCode(200);*/


/*
        //To verify code and print response in console
        given().get("http://services.groupkt.com/country/get/all").then().statusCode(200).log().all();*/



       /* //Verifying single content using org.hamcrest.Matchers library's equalTo method
        given().get("http://services.groupkt.com/country/get/iso2code/AF").then().body("RestResponse.result.name",equalTo("Afghanistan"));
        given().get("http://services.groupkt.com/country/get/all").then().body("RestResponse.result.name",hasItems("Afghanistan","Albania","Angola"));

      */

      /*  //using and keyword to increase readabilty
                given().param("key1","value1").and().header("key2","header").
                when().get("http://services.groupkt.com/country/get/all").
                then().statusCode(400).body("RestResponse.result.name",hasItems("Afghanistan","Albania","Angola"));
      */


        /*//recommend way to test all parameters using root feature
        given().get("http://services.groupkt.com/country/get/iso2code/AF").then().
                root("RestResponse.result").
                body("name",is("Afghanistan")).
                body("alpha2_code",is("AF"));*/


       /* //Post Request
        given().param("key1","value1").and().param("key2","value2").header("key3","header3").header("key4","header4").
                when().post("http://api.fonts.com/rest/json/Accounts/").
                then().statusCode(400).log().all();*/

       /*//To get all response as String
        String response=get("http://services.groupkt.com/country/get/iso2code/AF").asString();
        System.out.println("Repsone is " +response);*/


       /*////To get all response as InputStream
        InputStream stream=get("http://services.groupkt.com/country/get/iso2code/AF").asInputStream();
        System.out.println("Repsone is " +stream.toString().length());
        stream.close();*/


       /*//Extract details using path --> type1
        String href=
                when().get("http://jsonplaceholder.typicode.com/photos/1").
                        then().contentType(ContentType.JSON).
                        and().body("albumId",equalTo(1)).
                        extract().
                        path("url");
                 System.out.println("Url is " +href);
                 when().get(href).then().statusCode(200);
*/



        /*//Extract details using path --> type2

        String href =
                when().get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().getString("url");
                System.out.println("Url is " + href);
                when().get(href).then().statusCode(200);
       */



        /*//Extract Details as Response for further use
        io.restassured.response.Response response=
                when().
                get("http://jsonplaceholder.typicode.com/photos/1").
                then().
                extract().response();

        System.out.println("Content type: " +response.contentType());
        System.out.println("Status code: " +response.statusCode());*/



    //*This testcase will verify the respose schema with predefined existing schema*
    // * path: src/test/respurces/geo-schema.json





   /*  given().
     get("http://jsonplaceholder.typicode.com/photos/1").
     then().

     assertThat().body(matchesJsonSchemaInClasspath("//src//test//resources//expectedapiresponse.json"));
*/








/*//To get all attribute as List

        String response=get("http://services.groupkt.com/country/get/all").asString();
        List<String> ls=from(response).getList("RestResponse.result.name");
        System.out.println("List size: " +ls.size());
        for(String country: ls){
            if (country.equals("Afghanistan"))
                    System.out.println("Found the place");
        }*/



        //To get response as List and apply same condition on it
        //Groovy has a implicit variable called 'it' which represents current item in the list
        //In the below scenario it will print the country which got name length>30 characters

       /* String response=get("http://services.groupkt.com/country/get/all").asString();
        List<String> ls=from(response).getList("RestResponse.result.findAll{it.name.length()>30}.name");
        System.out.println(ls);*/








       // body(matchesJsonSchemaInClasspath("C:\\Users\\swathi.battula\\IdeaProjects\\MyAdstreamProject3\\target\\test-classes\\expectedresponse.json"));

/*

        io.restassured.response.Response response=
                when().
                        get("http://jsonplaceholder.typicode.com/photos/1").
                        then().
                        extract().response();

        System.out.println(response.asString());*/


      /*//To pass request Body
        Testrequest test= new Testrequest();
        test.setCreateDb("true");
        test.setDeleteDb("true");
        String response=
        given().body(test).when().contentType(ContentType.JSON).post("http://10.81.2.82:5000/v1/admin/bootstrapacl?$id$=4ef31ce1766ec96769b399c0").asString();

        System.out.println(response);
*/


        given().
                get("http://jsonplaceholder.typicode.com/photos/1").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("testPackage/expectedapiresponse.json"));

                //body(matchesJsonSchemaInClasspath("testPackage/expectedapoiresponse1.json"));

        //C://Users//swathi.battula//IdeaProjects//MyAdstreamProject3//src//test//resources//testPackage//expectedapiresponse.json

    }
   // equlJsonSchemaInClasspath

}

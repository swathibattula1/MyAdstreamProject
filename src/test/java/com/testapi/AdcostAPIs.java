package com.testapi;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.path.xml.XmlPath.from;

import static io.restassured.RestAssured.*;

public class AdcostAPIs {


    public String postapiCall() {
        //To pass request Body

        MyPojo test1 = new MyPojo();
        BudgetRegion test3 = new BudgetRegion();
        StageDetails test2 = new StageDetails();
        Data test4 = new Data();
        Organisation test5 = new Organisation();
        ProductionType test6 = new ProductionType();
        ContentType test7 = new ContentType();
        String[] agency1 = {"Abby Jenkins (Grey)"};

        //Organisation values
        test5.setProjects("null");
        test5.setDictionaryId("f02fe634-16fc-49b8-91c6-e54d388007cd");
        test5.setKey("RBU");
        test5.setValue("RBU");
        test5.setVisible("true");
        test5.setId("85950c29-da04-4603-adff-4d0bd4038bfd");

        //Budget region values
        test3.setId("fb0a8d23-a0d1-4aea-9084-e61bfce7fcca");
        test3.setKey("GREATER CHINA AREA");
        test3.setName("Greater China");

        //Production Type values
        test6.setId("00ff614b-822e-4d6a-8541-945cc2e2290f");
        test6.setKey("Post Production Only");
        test6.setValue("Post Production Only");


        //Content type values
        test7.setDictionaryId("9ec6a1cb-f38a-4a0b-9196-c1c9a3b63cd0");
        test7.setId("b0b2ddb4-1a40-4817-adbe-c0bce48b3a44");
        test7.setKey("Photography");
        test7.setProjects("null");
        test7.setValue("Still Image");
        test7.setVisible("true");

        //data values
        test4.setAgencyCurrency("USD");
        test4.setAgencyProducer(agency1);
        test4.setBudgetRegion(test3);
        test4.setCampaign("14 days challange (Pantene)");
        test4.setContentType(test7);
        test4.setCostType("Production");
        test4.setDescription("STUB");
        test4.setInitialBudget("80000");
        test4.setIsAIPE("false");
        test4.setIsCurrencyChanged("false");
        test4.setTitle("Swathi API test cost");
        test4.setSmoId("null");
        test4.setProductionType(test6);
        test4.setProjectId("59fc614b9ee5eb0c576b5c0c");
        test4.setOrganisation(test5);

        //Set Stage details
        test2.setData(test4);

        test1.setTemplateId("c17fc46e-6d25-4aa1-afb5-9913d02804df");
        test1.setStageDetails(test2);
        String response =
                given().body(test1).when().contentType(io.restassured.http.ContentType.JSON).post("http://10.81.2.82:5000/v1/costs?$id$=59fc5c6f9ee5eb0c576b5a91").asString();

        System.out.println(response);


        return response;
    }


    public String getapicall() {
        String response =
                given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                        when().get("http://10.81.2.82:5000/v1/costs/search").asString();
        System.out.println("All Retrieved costs are " + response);


        given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").
                then().statusCode(200).log().all();
        return response;

    }

    public void validategetapicallResponse(){
        // To perform response schema validation

        given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("testPackage/getcallResposne.json"));

    }

    public void getcallstatusCode(){
        io.restassured.response.Response response=
        given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").
                then().
                extract().response();

        System.out.println("Content type: " +response.contentType());
        System.out.println("Status code: " +response.statusCode());

    }

    /* String response =
                given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                        when().get("http://10.81.2.82:5000/v1/costs/search").asString();
        List<String> ls = from(response).getList("RestResponse.result.name");
        System.out.println("List size: " + ls.size());
        for (String country : ls) {
            if (country.equals("Afghanistan"))
                System.out.println("Found the place");*/



    //http://10.81.2.82:5000/v1/costs/search?pageNumber=1&pageSize=100&$id$=59fc5c6f9ee5eb0c576b5a91

    //To retrieve all the costs.
    public static void main(String[] args) {

        AdcostAPIs api = new AdcostAPIs();
        api.postapiCall();
        api.getapicall();
        api.validategetapicallResponse();
        api.getcallstatusCode();

    }
}
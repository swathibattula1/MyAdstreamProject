package steps;

import com.testapi.*;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import LIB.CommonClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class AdcostEndpointsSteps {

    private MyPojo test1 = new MyPojo();
    private BudgetRegion test3 = new BudgetRegion();
    private StageDetails test2 = new StageDetails();
    private Data test4 = new Data();
    private Organisation test5 = new Organisation();
    private ProductionType test6 = new ProductionType();
    private ContentType test7 = new ContentType();
    private String[] agency1 = {"Abby Jenkins (Grey)"};
    @Given("^GetAllcosts endpoint is available$")
    public void getallcostsEndpointIsAvailable() throws Throwable {
        System.out.println("endpoint to get all the costs is : http://10.81.2.82:5000/v1/costs/search");
    }


    @And("^perform the  get request$")
    public void performTheGetRequest() throws Throwable {
        String response = given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").asString();
    }

    @Then("^validate the response and get the status code$")
    public void validateTheResponseAndGetTheStatusCode() throws Throwable {
        io.restassured.response.Response response=
                given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                        when().get("http://10.81.2.82:5000/v1/costs/search").
                        then().
                        extract().response();

        System.out.println("Content type: " +response.contentType());
        System.out.println("Status code: " +response.statusCode());
    }

    @And("^print the reponse$")
    public String printTheReponse() throws Throwable {
        String response = given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").asString();
        System.out.println("All Retrieved costs are " + response);
        return response;
    }

   /* @And("^validate the response schema$")
    public void validateTheResponseSchema() throws Throwable {
        given().param("pageNumber", "1").and().param("pageSize", "100").and().param("$id$", "59fc5c6f9ee5eb0c576b5a91").
                when().get("http://10.81.2.82:5000/v1/costs/search").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("ExpectedResponses/GETapiresponse.json"));
    }*/


    @When("^I set the headers and parameters$")
    public void iSetTheHeadersAndParameters() throws Throwable {
        given().body(test1).when().contentType(io.restassured.http.ContentType.JSON).post("http://10.81.2.82:5000/v1/costs?$id$=59fc5c6f9ee5eb0c576b5a91");
    }

    @Given("^I have post cost details enpoint$")
    public void iHavePostCostDetailsEnpoint() throws Throwable {
        System.out.println("endpoint to get all the costs is : http://10.81.2.82:5000/v1/costs?");
    }

    @And("^I set the Request body and submit it$")
    public void iSetTheRequestBodyAndSubmitIt() throws Throwable {


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
    }

    @Then("^Then print the response of postcall$")
    public String validateTheResponseAndGetTheStatusCodeOfPostcall() throws Throwable {
        String response =
                given().body(test1).when().contentType(io.restassured.http.ContentType.JSON).post("http://10.81.2.82:5000/v1/costs?$id$=59fc5c6f9ee5eb0c576b5a91").asString();

        System.out.println(response);


        return response;
    }

    @Then("^print the response of postcall$")
    public void printTheResponseOfPostcall() throws Throwable {
        String response =
                given().body(test1).when().contentType(io.restassured.http.ContentType.JSON).post("http://10.81.2.82:5000/v1/costs?$id$=59fc5c6f9ee5eb0c576b5a91").asString();

        System.out.println(response);


    }

    @And("^I set the Requestbody and submit it$")
    public void iSetTheRequestbodyAndSubmitIt(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();

    }
}

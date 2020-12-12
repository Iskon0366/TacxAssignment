package com.tacx.stepdefinitions;


import com.tacx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TacxApiCollection {

    Response response;

    static String id;
    static String name;
    static String salary;
    static String age;
    Map<String,String> employee;
    Map<String,String> newEmployeeInfo;
    String path = ConfigurationReader.get("baseUrl");


    @When("User sends GET request to end point {string} and gets the json payload")
    public void userSendsGETRequestToEndPointAndGetsTheJsonPayload(String endPoint) {

        path +="/"+endPoint;
        response = given().accept(ContentType.JSON)
                .when().get(path);
        response.prettyPrint();

    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        Assert.assertEquals("Verify status code",statusCode,response.getStatusCode());
    }

    @And("status code text should be {string}")
    public void statusCodeTextShouldBe(String statusLineText) {
        System.out.println("response.statusLine() = " + response.statusLine());
        Assert.assertTrue("Verify status line text",response.statusLine().contains(statusLineText));
    }

    @And("{string} data should have {string} value")
    public void dataShouldHaveValue(String dataFromPayload, String expectedValue) {
        Assert.assertEquals(expectedValue,response.path(dataFromPayload));
    }

    @And("verify {string} has {int} items in payload")
    public void verifyHasItemsInPayload(String data, int expectedNum) {
        List<String> listOfIds = response.path(data+".id");
        Assert.assertEquals("Verify the items number",expectedNum,listOfIds.size());
    }

    @And("verify response header has {string} and verify its value {string}")
    public void verifyResponseHeaderHasAndVerifyItsValue(String headerName, String headerContent) {
        Assert.assertTrue("Verify the response has the header ",response.headers().hasHeaderWithName(headerName));
        Assert.assertTrue("Verify the header content",response.getHeader(headerName).contains(headerContent));
    }

    @And("get {int} st element data and save")
    public void getStElementDataAndSave(int num) {

        id = response.path("data["+num+"].id");
        name = response.path("data["+num+"].employee_name");
        salary = response.path("data["+num+"].employee_salary");
        age = response.path("data["+num+"].employee_age");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("salary = " + salary);
        System.out.println("age = " + age);

    }

    @When("User sends GET request to end point {string} with id and gets the json payload")
    public void userSendsGETRequestToEndPointWithIdAndGetsTheJsonPayload(String endPoint) {
        path +="/"+endPoint+"/"+id;
        System.out.println("id = " + id);
        response = given().accept(ContentType.JSON)
                .when().get(path);
        response.prettyPrint();
    }

    @And("employee data should match with the previous data values")
    public void employeeDataShouldMatchWithThePreviousDataValues() {

        Assert.assertEquals("Verify name value is same with previous",name,response.path("data.employee_name"));
        String salaryNew = Integer.toString(response.path("data.employee_salary"));
        Assert.assertEquals("Verify salary value is same with previous",salary,salaryNew);
        String ageNew = Integer.toString(response.path("data.employee_age"));
        Assert.assertEquals("Verify age value is same with previous",age,ageNew);

    }

    @When("User sends POST request to end point create with body and gets the json payload")
    public void userSendsPOSTRequestToEndPointCreateWithBodyAndGetsTheJsonPayload(Map<String,String> employeeInfo) {
        employee = employeeInfo;
        path +="/create";
        response = given().contentType(ContentType.JSON)
                .and().body(employee)
                .when().post(path);
        response.prettyPrint();
    }

    @And("body content should match with the given values")
    public void bodyContentShouldMatchWithTheGivenValues() {

        Assert.assertEquals("Verify the name value is same",employee.get("name"),response.path("data.name"));
        Assert.assertEquals("Verify the salary value is same",employee.get("salary"),response.path("data.salary"));
        Assert.assertEquals("Verify the age value is same",employee.get("age"),response.path("data.age"));
        id = Integer.toString(response.path("data.id"));
        System.out.println("id = " + id);

    }

    @Given("User gets the Id from previous created value and create a change")
    public void userGetsTheIdFromPreviousCreatedValueAndCreateAChange() {

        newEmployeeInfo = new HashMap<>();
        newEmployeeInfo.put("name","newNameUpdate");
        newEmployeeInfo.put("salary","36000");
        System.out.println("employee = " + newEmployeeInfo.toString());

    }

    @When("When User sends PUT request to end point {string} with a new change and gets the json payload")
    public void whenUserSendsPUTRequestToEndPointWithANewChangeAndGetsTheJsonPayload(String endPoint) {

        path +="/"+endPoint+"/"+id;
        response = given().contentType(ContentType.JSON)
                .and().body(newEmployeeInfo)
                .when().put(path);

        response.prettyPrint();

    }

    @And("verify the updated value passed")
    public void verifyTheUpdatedValuePassed() {

        Assert.assertEquals("Verify the name value is same",newEmployeeInfo.get("name"),response.path("data.name"));
        Assert.assertEquals("Verify the salary value is same",newEmployeeInfo.get("salary"),response.path("data.salary"));

    }

    @When("When User sends DELETE request to end point {string} with ID taken before and gets the json payload")
    public void whenUserSendsDELETERequestToEndPointWithIDTakenBeforeAndGetsTheJsonPayload(String endPoint) {
        path +="/"+endPoint+"/"+id;
        response = given().contentType(ContentType.JSON)
                .when().delete(path);

        response.prettyPrint();
    }

    @And("{string} data should have taken ID value")
    public void dataShouldHaveTakenIDValue(String data) {

        Assert.assertEquals("Verify the data value is same with previous taken id.",id,response.path("data"));


    }


}

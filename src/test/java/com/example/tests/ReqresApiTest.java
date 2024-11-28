package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ReqresApiTest {

    static {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testGetUserById() {
        // Send the request and capture the response
        Response response = given()
                .log().all()
                .when()
                .get("/users/2");

        // Print the status code in the console
        System.out.println("Status Code: " + response.getStatusCode());

        // Validate the response
        response.then()
                .log().all()
                .statusCode(200)
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"));
    }
}

package service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.RestRequestType;

public class CommonService {

    public Response post(Object responseBody, String endpoint){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(responseBody);
        // leaga config standard de serviciu cu configurarea clientului
//        Response response = performRequest(RestRequestType.POST, requestSpecification, endpoint);

        ServiceHelper.requestLogs(requestSpecification, endpoint, RestRequestType.POST.name());
        Response response = performRequest(RestRequestType.POST, requestSpecification, endpoint);

        ServiceHelper.responseLogs(response);

        return response;
    }

    public Response post(Object responseBody, String endpoint, String token){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer "+token);
        requestSpecification.body(responseBody);
        return performRequest(RestRequestType.POST, requestSpecification, endpoint);
    }

    public Response put(Object responseBody, String endpoint, String token){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer "+token);
        requestSpecification.body(responseBody);
        return performRequest(RestRequestType.PUT, requestSpecification, endpoint);
    }


    private  Response performRequest(RestRequestType restRequestType, RequestSpecification requestSpecification, String endpoint){
        return restRequestType.performRequest(requestSpecification, endpoint);
    }
}

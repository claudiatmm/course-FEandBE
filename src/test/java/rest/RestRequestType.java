package rest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public enum RestRequestType {

    //definim tipurile de operatii pe care le putem face cu configurarea din client

    POST() {
        @Override
        public Response performRequest(RequestSpecification requestSpecification, String endpoint) {
            return RestRequestType.prepareClient(requestSpecification).post(endpoint);
        }
    },
    PUT() {
        @Override
        public Response performRequest(RequestSpecification requestSpecification, String endpoint) {
            return RestRequestType.prepareClient(requestSpecification).put(endpoint);
        }
    },

    GET() {
        @Override
        public Response performRequest(RequestSpecification requestSpecification, String endpoint) {
            return RestRequestType.prepareClient(requestSpecification).get(endpoint);
        }
    },

    DELETE() {
        @Override
        public Response performRequest(RequestSpecification requestSpecification, String endpoint) {
            return RestRequestType.prepareClient(requestSpecification).delete(endpoint);
        }
    };


    // pregatim clientul
    private static RequestSpecification prepareClient(RequestSpecification requestSpecification) {
        requestSpecification.baseUri("https://demoqa.com");
        requestSpecification.contentType("application/json");
        return requestSpecification;
    }

    public abstract Response performRequest(RequestSpecification requestSpecification, String endpoint);

    }

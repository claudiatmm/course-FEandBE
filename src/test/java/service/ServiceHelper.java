package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import loggerUtility.LoggerUtility;
import lombok.SneakyThrows;

import java.io.IOException;

public class ServiceHelper {

    public static void requestLogs(RequestSpecification requestSpecification, String path, String method){
        LoggerUtility.info("=== Request Info ===");
        LoggerUtility.info(getRequestUri(path));
        LoggerUtility.info(getRequestMethod(method));
        LoggerUtility.info(getRequestBody(requestSpecification));


    }

    public static void responseLogs(Response response){
        LoggerUtility.info("=== Response Info ===");
        LoggerUtility.info(getResponseStatus(response));
        LoggerUtility.info(getResponseStatusCode(response));
        LoggerUtility.info(getResponseBody(response));

    }

    private static String getResponseStatusCode(Response response){
        return "Response STATUS: "+ response.getStatusLine();
    }

    private static String getResponseStatus(Response response){
        return "Response Status Code: "+response.getStatusCode();
    }

    private static String getResponseBody(Response response){
        return "Response Body: \n" + getPrettyJson(response);
    }


    private static String getRequestUri(String path){
       return "Request URI: https://demoqa.com" +path;
    }

    private static String getRequestMethod(String method){
        return "Request Method: " + method;
    }


    public static String getRequestBody(RequestSpecification requestSpecification){
        return "Request Body: \n" + getPrettyJson(requestSpecification);
    }

    @SneakyThrows(IOException.class)
    private static String getPrettyJson(RequestSpecification requestSpecification){
      // extras intr-un format json frumos
        String json = "";
        Object body = ((RequestSpecificationImpl) requestSpecification).getBody();

        if(body != null){
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.readTree(body.toString()).toPrettyString();
        }
        return json;
    }


    //poate nu toate metodele au body .. facem o metoda separat
    private static String getPrettyJson(Response response){
        if (response.getBody() != null){
            return response.getBody().asPrettyString();
        }

        else {
            return "";
        }
    }

}

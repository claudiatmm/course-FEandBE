package service.interfaceServices;

import io.restassured.response.Response;

public interface BookstoreServiceInterface {

    Response addBooksIntoAccount(Object requestBody, String token);
}

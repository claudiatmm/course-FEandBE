package service.interfaceServices;

import io.restassured.response.Response;

public interface AccountServiceInterface {

    Response createAccount(Object requestBody);
    Response generateToken(Object requestBody);
    Response obtainSpecificAccount(String userId, String token);




}

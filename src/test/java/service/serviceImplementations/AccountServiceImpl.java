package service.serviceImplementations;

import io.restassured.response.Response;
import service.apiServices.AccountService;
import service.interfaceServices.AccountServiceInterface;

public class AccountServiceImpl implements AccountServiceInterface {

    private AccountService accountService;

    public AccountServiceImpl(){
        accountService = new AccountService();
    }


    @Override
    public Response createAccount(Object requestBody) {
        return accountService.post(requestBody, "/Account/v1/User");
    }

    @Override
    public Response generateToken(Object requestBody) {
        return accountService.post(requestBody, "/Account/v1/GenerateToken");
    }

    @Override
    public Response obtainSpecificAccount(String userId, String token) {
        return null;
    }
}

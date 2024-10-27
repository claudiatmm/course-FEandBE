package actions.backend;

import context.DataContext;
import context.keys.RequestKeys;
import context.keys.ResponseKeys;
import io.restassured.response.Response;
import objectData.request.RequestAccount;
import objectData.response.account.ResponseAccountSuccess;
import objectData.response.token.ResponseTokenSuccess;
import org.testng.Assert;
import rest.RestRequestStatus;
import service.serviceImplementations.AccountServiceImpl;

public class AccountActions {

    //are ca rol sa puna in legatura - serviciu cu data si sa mange de actiuni de care avem noi nevoie

    private AccountServiceImpl accountService;

    public AccountActions() {
        accountService = new AccountServiceImpl();
    }

    public void createNewAccount() {
        RequestAccount requestBody = new RequestAccount("src/test/resources/requestData/CreateAccountData.json");
        Response restResponse = accountService.createAccount(requestBody);

        Assert.assertEquals(RestRequestStatus.SC_CREATED, restResponse.getStatusCode());

        ResponseAccountSuccess responseBody = restResponse.body().as(ResponseAccountSuccess.class);
        Assert.assertNotNull(responseBody.getUserId());

        System.out.println("here : " + responseBody.getUserId());

        DataContext.saveData(RequestKeys.REQUEST_OBJECT.getKey(), requestBody);
        DataContext.saveData(ResponseKeys.RESPONSE_USERID.getKey(), responseBody.getUserId());
    }


    public void generateTokenNewAccount() {
        RequestAccount requestBody = DataContext.getData(RequestKeys.REQUEST_OBJECT.getKey(), RequestAccount.class);

        Response restResponse = accountService.generateToken(requestBody);

        Assert.assertEquals(RestRequestStatus.SC_OK, restResponse.getStatusCode());
        ResponseTokenSuccess responseBody = restResponse.body().as(ResponseTokenSuccess.class);

        DataContext.saveData(ResponseKeys.RESPONSE_TOKEN.getKey(), responseBody.getToken());

    }

}

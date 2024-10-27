package steps.backend;

import actions.backend.AccountActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AccountServiceSteps {

    private AccountActions accountActions;

    @When("I create a new account from back-end")
    public void createAccountRequest(){
        accountActions = new AccountActions();
        accountActions.createNewAccount();
    }

    @And("I generate a token for the new account")
    public void generateTokenAccount(){
        accountActions = new AccountActions();
        accountActions.generateTokenNewAccount();
    }


}

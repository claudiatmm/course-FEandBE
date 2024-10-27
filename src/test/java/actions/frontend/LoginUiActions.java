package actions.frontend;

import context.DataContext;
import context.keys.RequestKeys;
import objectData.request.RequestAccount;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginUiActions extends BaseUiActions{

    private LoginPage loginPage;

    public LoginUiActions(WebDriver driver) {
        super(driver);
    }

    public void loginIntoApplication(){
        RequestAccount requestBody = DataContext.getData(RequestKeys.REQUEST_OBJECT.getKey(), RequestAccount.class);

        loginPage = new LoginPage(driver);
        loginPage.loginIntoApplication(requestBody);
    }

}

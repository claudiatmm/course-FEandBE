package pages;

import loggerUtility.LoggerUtility;
import objectData.request.RequestAccount;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    private WebElement usernameElement;

    @FindBy(id = "password")
    private WebElement passwordElement;

    @FindBy(id = "login")
    private WebElement loginElement;


    // conceptul de : Fluent Page Object
    public ProfilePage loginIntoApplication(RequestAccount requestAccount){
        usernameElement.sendKeys(requestAccount.getUserName());
        LoggerUtility.info("The user fills the username: " + requestAccount.getUserName());

        passwordElement.sendKeys(requestAccount.getPassword());
        LoggerUtility.info("The user fills the password: "+ requestAccount.getPassword());

        loginElement.click();
        LoggerUtility.info("The user clicks on login");

        return new ProfilePage(driver);
    }

}

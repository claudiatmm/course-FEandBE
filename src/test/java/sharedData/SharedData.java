package sharedData;

import loggerUtility.LoggerUtility;
import lombok.Getter;
import org.openqa.selenium.WebDriver;


@Getter
public class SharedData {

    private WebDriver driver;


    public void initializeDriver(){
        driver = new BrowserFactory().getPreparedDriver();
        LoggerUtility.info("Driver opened");
    }

    public void quitDriver(){
        driver.quit();
        LoggerUtility.info("Driver closed");
    }

}

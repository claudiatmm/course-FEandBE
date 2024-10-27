package sharedData.service.local;

import configFile.configNodes.FrontendConfig;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sharedData.service.BrowserService;

import java.time.Duration;

@Getter
public class ChromeBrowserService implements BrowserService {

    private WebDriver driver;


    @Override
    public void openBrowser(FrontendConfig frontendConfig) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(frontendConfig);
        driver = new ChromeDriver(options);
        driver.get(frontendConfig.url);
        driver.manage().window().maximize();

    }

    @Override
    public Object getBrowserOptions(FrontendConfig frontendConfig) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(frontendConfig.gpc);
        options.addArguments(frontendConfig.infoBars);
        options.addArguments(frontendConfig.sandbox);
        if(frontendConfig.headless){
            options.addArguments("--headless=new");
        }
        options.setImplicitWaitTimeout(Duration.ofSeconds(frontendConfig.implicitWait));
        options.setScriptTimeout(Duration.ofSeconds(frontendConfig.scriptTimeout));
        options.setPageLoadTimeout(Duration.ofSeconds(frontendConfig.pageLoadTimeout));

        return options;
    }
}

package sharedData.service.remote;

import configFile.configNodes.FrontendConfig;
import lombok.Getter;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import sharedData.service.BrowserService;

import java.net.URL;
import java.time.Duration;

@Getter
public class ChromeBrowserRemoteService implements BrowserService {

    private WebDriver driver;


    @SneakyThrows
    @Override
    public void openBrowser(FrontendConfig frontendConfig) {
        ChromeOptions options = (ChromeOptions) getBrowserOptions(frontendConfig);
        driver = new RemoteWebDriver(new URL(frontendConfig.remoteUrl),options);
        driver.get(frontendConfig.url);
        driver.manage().window().maximize();

    }

    @Override
    public Object getBrowserOptions(FrontendConfig frontendConfig) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(frontendConfig.gpc);
        options.addArguments(frontendConfig.infoBars);
        options.addArguments(frontendConfig.sandbox);
        options.addArguments("--headless=new");
        options.setImplicitWaitTimeout(Duration.ofSeconds(frontendConfig.implicitWait));
        options.setScriptTimeout(Duration.ofSeconds(frontendConfig.scriptTimeout));
        options.setPageLoadTimeout(Duration.ofSeconds(frontendConfig.pageLoadTimeout));

        return options;
    }
}


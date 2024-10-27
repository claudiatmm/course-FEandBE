package sharedData;

import configFile.GeneralXml;
import configFile.configNodes.Configuration;
import org.openqa.selenium.WebDriver;
import sharedData.service.local.ChromeBrowserService;
import sharedData.service.remote.ChromeBrowserRemoteService;

public class BrowserFactory {

    //rol: sa se uite pe ce env te afli si sa mange info in functie de asta

    public WebDriver getPreparedDriver() {
        String ciCd = System.getProperty("cicd");
        String browser = System.getProperty("browser");

        Configuration configuration = GeneralXml.createConfig(Configuration.class);

        if (Boolean.parseBoolean(ciCd)) {
            //Aici tot timpul va fi pe true cand e rulat remote in cicd
            configuration.frontendConfig.headless = true;
            switch (browser) {
                case BrowserType.BROWSER_CHROME:
                    ChromeBrowserRemoteService browserRemoteService = new ChromeBrowserRemoteService();
                    browserRemoteService.openBrowser(configuration.frontendConfig);
                    return browserRemoteService.getDriver();
                case BrowserType.BROWSER_EDGE:
            }
        } else {
            //esti pe local aici
            browser = configuration.frontendConfig.localBrowser;
            switch (browser) {
                case BrowserType.BROWSER_CHROME:
                    ChromeBrowserService browserService = new ChromeBrowserService();
                    browserService.openBrowser(configuration.frontendConfig);
                    return browserService.getDriver();
            }
        }
        return null;
    }
}

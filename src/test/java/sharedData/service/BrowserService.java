package sharedData.service;

import configFile.configNodes.FrontendConfig;

public interface BrowserService {

    void openBrowser(FrontendConfig frontendConfig);
    Object getBrowserOptions(FrontendConfig frontendConfig);

}

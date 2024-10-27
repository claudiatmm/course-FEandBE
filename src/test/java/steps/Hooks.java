package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import loggerUtility.LoggerUtility;
import sharedData.SharedData;

public class Hooks extends BaseSteps{

    public Hooks(SharedData sharedData) {
        super(sharedData);
    }

    //before scenario; se executa primul
    @Before(order = 1)
    public void beforeHooks(Scenario scenario){
        //acesata metoda: mange logurile catre raport
        LoggerUtility.addScenario(scenario.getName(), scenario);
    }

    @Before("@UI")
    public void beforeUI(){
       sharedData.initializeDriver();
    }

    @After
    public void afterHooks(Scenario scenario){
        LoggerUtility.finishScenario(scenario.getName());
    }

}

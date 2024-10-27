package loggerUtility;

import io.cucumber.java.Scenario;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerUtility {

    //vreau ca logurile mele sa apara si in raport
    //vreau ca logurile sa poata fi folosite peste tot

    @Getter
    private static Scenario scenario;

    private static final Logger logger = LogManager.getLogger();

    public static void addScenario(String scenarioName, Scenario scenario){
        LoggerUtility.scenario = scenario;
        String message = String.format("=============== Execution started : %s ===============", scenarioName);
        logger.info(message);
        scenario.log(message);
    }

    public static void finishScenario(String scenarioName){
        String message = String.format("=============== Execution finished : %s ===============", scenarioName);
        logger.info(message);
        scenario.log(message);
    }

    public static void info(Object message){
        logger.info(message);
        scenario.log(message.toString());
    }

    public static void error(Object message){
        String finalMessage = String.format("ERROR: %s ", message);
        logger.error(finalMessage);
        scenario.log(message.toString());
    }

}

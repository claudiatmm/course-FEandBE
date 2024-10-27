package context;

import java.util.HashMap;

public class DataContext {

    // mapare context pe thread daca vrei ca mai multe features sa foloseasca acelasi data contex. Asa
    //valorile nu se suprascriu cand ruleaza 2 feture in paralel !!

    private static final HashMap<String, Object> testData = new HashMap<>();

    public static void saveData(String key, Object value){
        testData.put(key, value);
    }

    public static <T> T getData(String key, Class<T> valueType){
        if(checkKeyPresence(key)){
            Object value = testData.get(key);
            if(valueType.isInstance(value)){  // daca e de tipul obiectului meu
                return valueType.cast(value);
            }
            else {
                throw new ClassCastException("Value associated with key "+ key + "is not displayed");
            }
        }
        else {
            throw new RuntimeException("There is no value stored on " + key);
        }

    }


    public static boolean checkKeyPresence(String key){
        return testData.containsKey(key);
    }


    public static void clearContext(){
        testData.clear();
    }

}

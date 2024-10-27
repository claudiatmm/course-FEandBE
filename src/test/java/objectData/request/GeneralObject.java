package objectData.request;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class GeneralObject {

    protected void fromJsonFileToObject(String dataPath){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.readerForUpdating(this).readValue(new File(dataPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

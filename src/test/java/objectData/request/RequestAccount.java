package objectData.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

@Data
public class RequestAccount extends GeneralObject {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;



    public RequestAccount(String dataPath){
        fromJsonFileToObject(dataPath);
        adjustProperties();
    }

    private void adjustProperties(){
        userName += UUID.randomUUID().toString();
    }

}

package objectData.response.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import objectData.response.model.BookObject;

import java.util.List;

@Getter
public class ResponseTokenSuccess {


    @JsonProperty("token")
    private String token;

    @JsonProperty("expires")
    private String expires;

    @JsonProperty("status")
    private String status;

    @JsonProperty("result")
    private String result;
}

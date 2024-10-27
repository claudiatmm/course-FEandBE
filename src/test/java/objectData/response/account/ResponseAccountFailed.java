package objectData.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ResponseAccountFailed {

    @JsonProperty("code")
    private int code;

    @JsonProperty("message")
    private String message;

}

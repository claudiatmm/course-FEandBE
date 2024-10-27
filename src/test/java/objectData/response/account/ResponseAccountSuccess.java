package objectData.response.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import objectData.response.model.BookObject;

import java.util.List;

@Getter
public class ResponseAccountSuccess {

    @JsonProperty("userID")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<BookObject> books;
}

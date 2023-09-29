package dev.maGroup.surveys.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private String userID;
    private String email;
    private String password;
    private String name;
    private List<String> surveysCreated; // Added surveysCreated field

    public void setId(String id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurveysCreated(List<String> surveysCreated) {
        this.surveysCreated = surveysCreated;
    }

}

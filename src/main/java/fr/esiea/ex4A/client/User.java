package fr.esiea.ex4A.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Pattern;

public class User {
    private final String userName;
    private final String userMail;
    private final String userTwitter;
    private final Sex userSex;
    private final Sex userSexPref;

    @Pattern(regexp="^[A-Z]{2}$")
    private final String userCountry;

    public enum Sex {
        M,
        F,
        O
    }

    @JsonCreator
    public User(@JsonProperty(required = true, value="userName") String userName,
                @JsonProperty(required = true, value="userMail") String userMail,
                @JsonProperty(required = true, value="userTwitter") String userTwitter,
                @JsonProperty(required = true, value="userCountry") String userCountry,
                @JsonProperty(required = true, value="userSex") Sex userSex,
                @JsonProperty(required = true, value="userSexPref") Sex userSexPref) {
        this.userName = userName;
        this.userMail = userMail;
        this.userTwitter = userTwitter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
    }

    @Override
    public String toString() {
        return "User{" +
            "userEmail='" + userMail + '\'' +
            ", userName='" + userName + '\'' +
            ", userTweeter='" + userTwitter + '\'' +
            ", userCountry='" + userCountry + '\'' +
            ", userSex=" + userSex +
            ", userSexPref=" + userSexPref +
            '}';
    }
}

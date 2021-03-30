package fr.esiea.ex4A.client;

import fr.esiea.ex4A.client.UserInfo;
import fr.esiea.ex4A.client.UserInfo.Sex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserInfoTest {

    @Test
    public void userToStringTest() {
        String userMail = "test";
        String userName = "test@test.fr";
        String userTwitter = "test";
        String userCountry = "FR";
        Sex userSex = Sex.M;
        Sex userSexPref = Sex.O;
        UserInfo userInfo = new UserInfo(userMail, userName, userTwitter, userCountry, userSex, userSexPref);
        String expectedString = "{" +
            "userMail='" + userMail + '\'' +
            ", userName='" + userName + '\'' +
            ", userTweeter='" + userTwitter + '\'' +
            ", userCountry='" + userCountry + '\'' +
            ", userSex=" + userSex +
            ", userSexPref=" + userSexPref +
            '}' + '\'';
        assertEquals(expectedString, userInfo.toString());
    }
}

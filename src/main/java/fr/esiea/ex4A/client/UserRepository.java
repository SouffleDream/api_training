package fr.esiea.ex4A.client;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public final List<UserInfo> userInfoList;

    public UserRepository() {
        userInfoList = new ArrayList<>();
    }

    public void addUser(UserInfo userInfo) {
        userInfoList.add(userInfo);
    }
}

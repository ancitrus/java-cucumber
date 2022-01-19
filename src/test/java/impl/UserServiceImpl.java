package impl;

import api.User;
import config.TestConfig;
import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static context.RunContext.RUN_CONTEXT;
import static io.restassured.RestAssured.given;

@Log4j2
public class UserServiceImpl implements UserService {
    TestConfig testConfig = new TestConfig();

    @Override
    public List<User> getUsers(String url) {
        String URL = testConfig.getURL() + url;

        List<User> users = new ArrayList<>();

        ValidatableResponse r = given()
                .get(URL)
                .then().log().ifError();

        RUN_CONTEXT.put("response", r);

        try {
            users = r.extract().jsonPath().getList("data.", User.class);
        } catch (Exception e){
            log.error("Users request exception: " + Arrays.toString(e.getStackTrace()));
        }

        return users;
    }
}

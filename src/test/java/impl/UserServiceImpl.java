package impl;

import api.User;
import config.TestConfig;
import io.restassured.response.ValidatableResponse;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import service.UserService;

import java.util.*;

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

    @Override
    public String regUser(String email, String password) {
        String URL = testConfig.getRegUrl();

        Map<String, Object> creds = new HashMap<>();
        creds.put("email", email);
        creds.put("password", password);

        ValidatableResponse r = given()
                .contentType("application/json")
                .body(creds)
                .when()
                .post(URL)
                .then().log().ifError();

        RUN_CONTEXT.put("response", r);

        return r.extract().body().jsonPath().getString("token");
    }
}

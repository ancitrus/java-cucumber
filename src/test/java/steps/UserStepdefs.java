package steps;

import api.User;
import impl.UserServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.UserService;

import java.util.List;

import static context.RunContext.RUN_CONTEXT;

public class UserStepdefs {
    UserService userService = new UserServiceImpl();

    @Given("Get Users {string} Request")
    public void getUsersRequest(String url) {
        userService.getUsers(url);
    }

    @Then("Response code is: {string}")
    public void responseCodeIs(String status) {
        ValidatableResponse response = RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        int expectedStatus = Integer.parseInt(status);
        Assert.assertEquals(actualStatus, expectedStatus);
    }

}

package steps;

import impl.UserServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import service.UserService;

import static context.RunContext.RUN_CONTEXT;

public class UserStepdefs {
    UserService userService = new UserServiceImpl();

    @Given("Get Users {string} Request")
    public void getUsersRequest(String url) {
        userService.getUsers(url);
    }

    @Given("Send request with attributes {string} and {string}")
    public void sendPOSTRequestWithAttributes(String email, String password) {
        String token = userService.regUser(email, password);
        ValidatableResponse response = RUN_CONTEXT.get("response", ValidatableResponse.class);
        if(response.extract().statusCode() == 200){
            Assert.assertNotNull(token);
        }
    }

    @Then("Response code is: {string}")
    public void responseCodeIs(String status) {
        ValidatableResponse response = RUN_CONTEXT.get("response", ValidatableResponse.class);
        int actualStatus = response.extract().statusCode();
        int expectedStatus = Integer.parseInt(status);
        Assert.assertEquals(expectedStatus, actualStatus);
    }

}

package testRunner;

import config.Setup;
import controller.UserController;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserBalanceCheckTestRunner extends Setup{
    @Test(priority = 1, description = "Check invalid customer balance")
    public void invalidBalanceCheck(){
        UserController userController = new UserController(prop);
        Response response = userController.balanceCheck(prop.getProperty("CustomerPhoneNumber3"));
        System.out.println(response.asString());
        JsonPath jsonPath=response.jsonPath();
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User not found");
    }
    @Test(priority = 2, description = "Check Customer1 balance")
    public void userBalanceCheck(){
        UserController userController = new UserController(prop);
        Response response = userController.balanceCheck(prop.getProperty("CustomerPhoneNumber1"));
        System.out.println(response.asString());
        JsonPath jsonPath=response.jsonPath();
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User balance");
        Allure.description("Admin can check user's balance");
    }
}

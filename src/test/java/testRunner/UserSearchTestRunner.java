package testRunner;

import config.Setup;
import controller.UserController;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserSearchTestRunner extends Setup {
    @Test(priority = 1, description = "Search a Agent by an invalid ID")
    public void invalidSearchUser(){
        UserController userController = new UserController(prop);
        Response response = userController.searchUser(prop.getProperty("AgentId1"));
        System.out.println(response.asString());
        JsonPath jsonPath=response.jsonPath();
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User not found");
    }
    @Test(priority = 2, description = "Search a Agent by ID")
    public void searchUser(){
        UserController userController = new UserController(prop);
        Response response = userController.searchUser(prop.getProperty("AgentId"));
        System.out.println(response.asString());
        JsonPath jsonPath=response.jsonPath();
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User found");
        Allure.description("Admin search new user by his Id");
    }

}

package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import config.UserModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class UserController {
    Properties prop;

    public UserController(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";

    }

    public Response adminLogin(UserModel userModel) {
        Response response = given().contentType("application/json").body(userModel).when().post("/user/login");
        return response;
    }

    public Response createUser(UserModel userModel) {
        Response response = given().contentType("application/json").body(userModel)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/user/create");
        return response;
    }

    public Response searchUser(String userId) {
        Response response = given().contentType("application/json")
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .when().get("user/search/id/" + userId);
        return response;
    }
    public Response balanceCheck(String userPhoneNumber) {
        Response response = given().contentType("application/json")
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().get("/transaction/balance/" + userPhoneNumber);
        return response;
    }
    public Response deleteUser(String userId) {
        Response response = given().contentType("application/json")
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().delete("user/delete/" + userId);
        return response;
    }
}

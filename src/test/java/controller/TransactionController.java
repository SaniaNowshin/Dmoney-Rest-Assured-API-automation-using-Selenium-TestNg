package controller;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import config.TransactionModel;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TransactionController {
    Properties prop;

    public TransactionController(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI = "http://dmoney.roadtocareer.net";

    }

    public Response deposit(TransactionModel transactionModel) {
        Response response = given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/deposit");
        return response;
    }
    public Response sendMoney(TransactionModel transactionModel) {
        Response response = given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/sendmoney");
        return response;
    }
    public Response withdrawal(TransactionModel transactionModel) {
        Response response = given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/withdraw");
        return response;
    }
    public Response payment(TransactionModel transactionModel) {
        Response response = given().contentType("application/json").body(transactionModel)
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .when().post("/transaction/payment");
        return response;
    }

}


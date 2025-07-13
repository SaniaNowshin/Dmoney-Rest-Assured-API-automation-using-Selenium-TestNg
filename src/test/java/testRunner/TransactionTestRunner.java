package testRunner;

import config.Setup;
import controller.TransactionController;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import config.TransactionModel;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TransactionTestRunner extends Setup {
      @Test(priority = 1, description = "Unsuccessful Transaction from System Account To Agent Account: Deposit 20,0000tk from system to agent")
       public void invalidDepositSystemToAgent(){
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account("SYSTEM");
           transactionModel.setTo_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setAmount("20000");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.deposit(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Limit exceeded."));
       }

       @Test(priority = 2, description = "Unsuccessful transaction from Agent To Customer1 deposit with Insufficient balance")
       public void invalidDepositAgentToCustomer1() {
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setTo_account(prop.getProperty("CustomerPhoneNumber1"));
           transactionModel.setAmount("20000");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.deposit(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Insufficient balance"));
       }
       @Test(priority = 3, description = "Unsuccessful Money deposit by Customer to an Agent: Only Agent can deposit money")
       public void invalidDepositCustomer1ToAgent() {
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
           transactionModel.setTo_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setAmount("20");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.deposit(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Only Agent can deposit money"));
       }
       @Test(priority = 4, description = "Successful Transaction from System Account To Agent Account: Deposit 2000tk from system to agent")
       public void depositSystemToAgent(){
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account("SYSTEM");
           transactionModel.setTo_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setAmount("2000");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.deposit(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assert.assertEquals(actualResult, "Deposit successful");
       }
       @Test(priority = 5, description = "Successful Transaction from Agent to Customer: Deposit 1500tk to customer 1 from agent")
       public void DepositAgentToCustomer1() {
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setTo_account(prop.getProperty("CustomerPhoneNumber1"));
           transactionModel.setAmount("1500");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.deposit(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Deposit successful"));
       }
       @Test(priority = 6, description = "Unsuccessful Money withdraw by Customer to another Customer: Customer cannot withdraw money from another customer")
       public void invalidWithdrawCustomer1ToCustomer2() {
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
           transactionModel.setTo_account(prop.getProperty("CustomerPhoneNumber2"));
           transactionModel.setAmount("200");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.withdrawal(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Customer cannot withdraw money from another customer"));
       }
       @Test(priority = 7, description = "Successful Money withdraw by Customer to an Agent")
       public void withdrawCustomer1ToAgent() {
           TransactionModel transactionModel = new TransactionModel();
           transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
           transactionModel.setTo_account(prop.getProperty("AgentPhoneNumber"));
           transactionModel.setAmount("100");

           controller.TransactionController transactionController =new controller.TransactionController(prop);
           Response response = transactionController.withdrawal(transactionModel);

           System.out.println(response.asString());
           JsonPath jsonPath =response.jsonPath();
           String actualResult= jsonPath.get("message");
           Assertions.assertTrue(actualResult.contains("Withdraw successful"));
       }
    @Test(priority = 8, description = "Unsuccessful send money by Customer to an Agent")
    public void invalidSendMoneyCustomer1ToAgent() {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
        transactionModel.setTo_account(prop.getProperty("AgentPhoneNumber"));
        transactionModel.setAmount("500");

        TransactionController transactionController = new TransactionController(prop);
        Response response = transactionController.sendMoney(transactionModel);

        System.out.println(response.asString());
        JsonPath jsonPath = response.jsonPath();
        String actualResult = jsonPath.get("message");
        Assertions.assertTrue(actualResult.contains("should not be an agent account"));
    }

    @Test(priority = 9, description = "Successful send money by Customer to a another customer")
    public void SendMoneyCustomer1ToCustomer2() {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
        transactionModel.setTo_account(prop.getProperty("CustomerPhoneNumber2"));
        transactionModel.setAmount("10");

        TransactionController transactionController = new TransactionController(prop);
        Response response = transactionController.sendMoney(transactionModel);

        System.out.println(response.asString());
        JsonPath jsonPath = response.jsonPath();
        String actualResult = jsonPath.get("message");
        Assertions.assertTrue(actualResult.contains("Send money successful"));
    }
    @Test(priority = 10, description = "Unsuccessful Payment To an invalid  Merchant Number from customer 2")
    public void invalidPaymentCustomer2ToMerchant() {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
        transactionModel.setTo_account(prop.getProperty("MerchantPhoneNumber1"));
        transactionModel.setAmount("50");

        TransactionController transactionController = new TransactionController(prop);
        Response response = transactionController.payment(transactionModel);

        System.out.println(response.asString());
        JsonPath jsonPath = response.jsonPath();
        String actualResult = jsonPath.get("message");
        Assertions.assertTrue(actualResult.contains("Account does not exist"));
    }
    @Test(priority = 11, description = "Successful Payment To a Valid Merchant Number from customer 2")
    public void paymentCustomer2ToMerchant() throws ConfigurationException, FileNotFoundException {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFrom_account(prop.getProperty("CustomerPhoneNumber1"));
        transactionModel.setTo_account(prop.getProperty("MerchantPhoneNumber"));
        transactionModel.setAmount("10");

        TransactionController transactionController = new TransactionController(prop);
        Response response = transactionController.payment(transactionModel);

        System.out.println(response.asString());
        JsonPath jsonPath = response.jsonPath();
        String actualResult = jsonPath.get("message");
        Assertions.assertTrue(actualResult.contains("Payment successful"));
    }
}

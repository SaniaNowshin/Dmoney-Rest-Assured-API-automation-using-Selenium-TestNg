package testRunner;

import com.github.javafaker.Faker;
import config.Setup;
import utils.Utils;
import controller.UserController;
import io.qameta.allure.Allure;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import config.UserModel;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class UserTestRunner extends Setup {
    @Test(priority = 1, description = "Check if user can login successfully")
    public void login() throws ConfigurationException, FileNotFoundException {
        UserModel userModel = new UserModel();
        userModel.setEmail("admin@roadtocareer.net");
        userModel.setPassword("1234");

        UserController userController = new UserController(prop);
        Response response = userController.adminLogin(userModel);
        System.out.println(response.asString());
        JsonPath jsonPath =response.jsonPath();
        String token = jsonPath.get("token");
        System.out.println(token);
        Utils.setEnvVar("token",token);
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "Login successful");
        Allure.description("Admin inputs valid credential to generate token");
    }
    @Test(priority = 2, description = "Create user Customer1")
    public void createCustomerUser1() throws ConfigurationException, FileNotFoundException {
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        String email="sania"+ Utils.generateRandom(1000,9999)+"@gmail.com";
        String password="2345";
        String phone_number="0134"+ Utils.generateRandom(1000000,9999999);
        UserModel userModel = new UserModel();
        userModel.setName(fullName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid("123456789");
        userModel.setRole("Customer");

        UserController userController = new UserController(prop);
        Response response = userController.createUser(userModel);//jackson databind dependency use kore payload er jaigai model send kora jai
        System.out.println(response.asString());

        JsonPath jsonPath =response.jsonPath();
        int CustomerId1 =jsonPath.get("user.id");
        String CustomerEmail1 =jsonPath.get("user.email");
        String CustomerPhoneNumber1 =jsonPath.get("user.phone_number");

        Utils.setEnvVar("CustomerId1", String.valueOf(CustomerId1));
        Utils.setEnvVar("CustomerEmail1", CustomerEmail1);
        Utils.setEnvVar("CustomerPhoneNumber1", CustomerPhoneNumber1);
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User created");
        Allure.description("Admin can create a Customer1");
    }

  @Test(priority = 3, description = "Create user Customer2")
    public void createCustomerUser2() throws ConfigurationException, FileNotFoundException {
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        String email="sania"+ Utils.generateRandom(1000,9999)+"@gmail.com";
        String password="2345";
        String phone_number="0134"+ Utils.generateRandom(1000000,9999999);
        UserModel userModel = new UserModel();
        userModel.setName(fullName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid("123456789");
        userModel.setRole("Customer");

        UserController userController = new UserController(prop);
        Response response = userController.createUser(userModel);//jackson databind dependency use kore payload er jaigai model send kora jai
        System.out.println(response.asString());

        JsonPath jsonPath =response.jsonPath();
        int CustomerId2 =jsonPath.get("user.id");
        String CustomerEmail2 =jsonPath.get("user.email");
        String CustomerPhoneNumber2 =jsonPath.get("user.phone_number");

        Utils.setEnvVar("CustomerId2", String.valueOf(CustomerId2));
        Utils.setEnvVar("CustomerEmail2", CustomerEmail2);
        Utils.setEnvVar("CustomerPhoneNumber2", CustomerPhoneNumber2);
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User created");
        Allure.description("Admin can create a Customer2");
    }
   @Test(priority = 4, description = "Create Agent user")
    public void createAgentUser() throws ConfigurationException, FileNotFoundException {
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        String email="sania"+ Utils.generateRandom(1000,9999)+"@gmail.com";
        String password="2345";
        String phone_number="0134"+ Utils.generateRandom(1000000,9999999);
        UserModel userModel = new UserModel();
        userModel.setName(fullName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid("123456789");
        userModel.setRole("Agent");

        UserController userController = new UserController(prop);
        Response response = userController.createUser(userModel);//jackson databind dependency use kore payload er jaigai model send kora jai
        System.out.println(response.asString());

        JsonPath jsonPath =response.jsonPath();
        int AgentId =jsonPath.get("user.id");
        String AgentEmail =jsonPath.get("user.email");
        String AgentPhoneNumber =jsonPath.get("user.phone_number");

        Utils.setEnvVar("AgentId", String.valueOf(AgentId));
        Utils.setEnvVar("AgentEmail", AgentEmail);
        Utils.setEnvVar("AgentPhoneNumber", AgentPhoneNumber);
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User created");
        Allure.description("Admin can create an Agent");
    }
    @Test(priority = 5, description = "Create Merchant user")
    public void createMerchantUser() throws ConfigurationException, FileNotFoundException {
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        String email="sania"+ Utils.generateRandom(1000,9999)+"@gmail.com";
        String password="2345";
        String phone_number="0134"+ Utils.generateRandom(1000000,9999999);
        UserModel userModel = new UserModel();
        userModel.setName(fullName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhone_number(phone_number);
        userModel.setNid("123456789");
        userModel.setRole("Merchant");

        UserController userController = new UserController(prop);
        Response response = userController.createUser(userModel);//jackson databind dependency use kore payload er jaigai model send kora jai
        System.out.println(response.asString());

        JsonPath jsonPath =response.jsonPath();
        int MerchantId =jsonPath.get("user.id");
        String MerchantEmail =jsonPath.get("user.email");
        String MerchantPhoneNumber =jsonPath.get("user.phone_number");

        Utils.setEnvVar("MerchantId", String.valueOf(MerchantId));
        Utils.setEnvVar("MerchantEmail", MerchantEmail);
        Utils.setEnvVar("MerchantPhoneNumber", MerchantPhoneNumber);
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User created");
        Allure.description("Admin can create a Merchant");
    }

 //   @Test(priority = 4, description = "Delete created user")
    public void deleteUser(){
        UserController userController = new UserController(prop);
        Response response = userController.deleteUser(prop.getProperty("userId"));
        System.out.println(response.asString());
        JsonPath jsonPath=response.jsonPath();
        String actualResult= jsonPath.get("message");
        Assert.assertEquals(actualResult, "User deleted successfully");
        Allure.description("Admin deleted the new user for test purpose");
    }
}

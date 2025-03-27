package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UseEndPointsImpl;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {
	
@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)

public void testPostUser(String userID, String userName, String firstName, String lastName, String passWord, String phone) {

    User userPayLoad = new User();
    
    // ✅ Convert userID from String to Integer inside the test
    try {
        userPayLoad.setId(Integer.parseInt(userID.trim())); 
    } catch (NumberFormatException e) {
        Assert.fail("Invalid userID format: " + userID);
        return;
    }

    userPayLoad.setUsername(userName);
    userPayLoad.setFirstName(firstName);
    userPayLoad.setLastName(lastName);
    userPayLoad.setPassword(passWord);
    userPayLoad.setPhone(phone);  

    Response response = UseEndPointsImpl.CreateUser(userPayLoad);
    Assert.assertEquals(response.getStatusCode(), 200);
}}

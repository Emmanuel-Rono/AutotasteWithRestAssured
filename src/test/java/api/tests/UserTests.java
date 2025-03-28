package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UseEndPointsImpl;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayLoad;
	public Logger logger;
	

	@BeforeClass
	
	public void GenerateData()
	{
		
		faker = new Faker();
		userPayLoad = new User();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setId(faker.number().randomDigitNotZero());
        userPayLoad.setUsername(faker.name().username());
        userPayLoad.setFirstName(faker.name().firstName());
        userPayLoad.setLastName(faker.name().lastName());
        userPayLoad.setEmail(faker.internet().emailAddress());
        userPayLoad.setPassword(faker.internet().password(5,10));
        userPayLoad.setPhone(faker.phoneNumber().cellPhone());  
      
        //userPayLoad.setUserStatus(faker.number().numberBetween(0, 2));
        
        logger=LogManager.getLogger(this.getClass());
        
		
	}
	
	@Test(priority=1)
	public void testCreateUser()
	{
	
	logger.info("*************Creating USer**********");
	{ 
		Response response =UseEndPointsImpl.CreateUser(userPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		logger.info("*************End of Creation**********");
	}
	/*
	@Test(priority=2)
	public void testGetUser()
	{
		Response response =UseEndPointsImpl.GetUser(this.userPayLoad.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		

	}
	@Test(priority=3)
	public void testUpdateUser()
	{
	userPayLoad.setFirstName(faker.name().firstName());
	userPayLoad.setLastName(faker.name().lastName());
    userPayLoad.setEmail(faker.internet().emailAddress());
    
		Response response =UseEndPointsImpl.UpdateUser(this.userPayLoad.getUsername(), userPayLoad);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	*/


}}

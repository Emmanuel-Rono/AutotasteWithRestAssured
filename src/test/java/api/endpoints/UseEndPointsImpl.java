package api.endpoints;

 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.response.Response;



import io.restassured.http.ContentType;

public class UseEndPointsImpl {
	
	static ResourceBundle  getUrl()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
			 
 public static  Response CreateUser(User Payload)
	{
	 String postUrl= getUrl().getString("postUrl");
	 
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(Payload)
		
		.when()
		  .post(postUrl);
		return response;
	
	}
 
 
public static Response GetUser(String username)
{

	String getUrl= getUrl().getString("getUrl");
	
		Response response = given()
			
		  
		  .pathParam("username",username)
		  
		 .when()
		   .get( getUrl); 
		
		return response;
	}


public static Response UpdateUser(String username, User Payload)
{
	Response response = given()
			.contentType(ContentType.JSON)
			   .accept(ContentType.JSON)
			   .pathParam("username",username)  
	 .when()
	   .put( apiroutes.putUrl); 
	
	return response;
}
	
	
	
}

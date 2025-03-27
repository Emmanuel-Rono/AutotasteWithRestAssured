package api.endpoints;

 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;



import io.restassured.http.ContentType;

public class UseEndPointsImpl {
	
	 
 public static  Response CreateUser(User Payload)
	{
		Response response = given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(Payload)
		
		.when()
		  .post(apiroutes.postUrl);
	
		return response;
	
	}
 
public static Response GetUser(String username)
	{
		Response response = given()
			
		  
		  .pathParam("username",username)
		  
		 .when()
		   .get( apiroutes.getUrl); 
		
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

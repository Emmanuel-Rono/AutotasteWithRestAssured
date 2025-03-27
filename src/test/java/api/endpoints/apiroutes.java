package api.endpoints;


	
/*
GET user() :  https://petstore.swagger.io/v2/user/{username}
POST User(Post): https://petstore.swagger.io/v2/user/{username}
DELETE user: https://petstore.swagger.io/v2/user/{username}
POST User:  https://petstore.swagger.io/v2/user 

*/
public class apiroutes 
{
	public static String base_url="https://petstore.swagger.io/v2";
	public static String postUrl = base_url +"/user"; 
	public static String getUrl = base_url +"/user/{username}";
	public static String deleteUrl= base_url+ "/user/{username}";
	public static String putUrl = base_url +"/user/{username}"; 

}

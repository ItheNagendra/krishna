package htmlMethods;

import org.testng.annotations.Test;
//https://github.com/rest-assured/rest-assured/wiki/Usage  =  this is link for following 3 imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class QueryaAndPath_parameter {
	
	
	/*
	 * https://reqres.in/api/users?page=2
	 * resource : https://reqres.in/api
	 * path parameter : /users
	 * Query parameter :page=2
	 */
	
  @Test
  public void testparameter() 
  {
	  
	  given()
	  .pathParam("path","users")
	  .queryParam("page", 2)
	  
	  //.when().get("https://reqres.in/api/users?page=2")
	     .when() .get("https://reqres.in/api/{path}") 
	  .then().log().body();
	  
	  
	  
  }
}

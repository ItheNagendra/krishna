package htmlMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Request_01_GET {
  @Test
  public void getRequest_SingleUser() 
  {
	    
	  // this old type assured method , new method is given in another class
	 Response res = RestAssured.get("https://reqres.in/api/users/2");
	  int statuscode=res.statusCode();
	  System.out.println("Response status code is:" + statuscode);
	  
	  Assert.assertEquals(200,statuscode,"Failed : statuscode is not match");
	  System.out.println("Statuscode is matched");
	  
	  
	  System.out.println("session id is:" + res.sessionId());
	  System.out.println("status line is :" + res.getStatusLine());
	  
	  }
}

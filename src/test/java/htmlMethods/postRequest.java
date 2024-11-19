package htmlMethods;

import org.testng.annotations.Test;
// https://github.com/rest-assured/rest-assured/wiki/Usage  =  this is link for following 3 imports
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


/* 
 * Post ---> request payload (means creat data in resource) - 2 ways for this method
 * 1.Hashmap
 * 2.POJO - plain old java object class
 */

    // take Endpoint of dumy API

public class postRequest {
	
  @Test(priority=1)
  public void post_HashMap()
  { 
	  
	  // creat a data  ( request payload )
	  HashMap<String,Object> data =new  HashMap<String,Object>();
	  data.put("name","Nagendra");
	  data.put("job","QA");
	  
	  

	     given() 
            .contentType("application/json")   // header - passing data is not impotant but passing it in form of json is important thats y containsType is given
            .body(data )
		  
		 .when()
		 .post("https://reqres.in/api/users")
		 
		 .then()
		 .statusCode(201)
		 .log().all();
	    
  }
  

	// for this we have created seperate pojo class first the here i write code and creating object we fetch pojo class data here
  @Test(priority=2)
  public void post_pojo()
  { 
	   // creat data/object
	  pojoDemo pojo = new pojoDemo();
	  pojo.setName("Vishal");
	  pojo.setJob("tester");
	  

	     given() 
         .contentType("application/json")   // header - passing data is not impotant but passing it in form of json is important thats y containsType is given
         .body(pojo)
		  
		 .when()
		 .post("https://reqres.in/api/users")
		 
		 .then()
		 .statusCode(201)
		 .log().all();
	    
  
  } 
}

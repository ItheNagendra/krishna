package htmlMethods;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class put_delete_Request {
  @Test (priority=1)
  public void putRequest_update()     // put means updating data/resource  , patch - partial update
  {
	 System.out.println("put request is executing");
	  // Endpoint - https://reqres.in/api/users/2
	  
	  // creat data/object
	  pojoDemo p1 = new pojoDemo();
	  p1.setName("Ajay");
	  p1.setJob("Developer");
	  

	     given()  
	      .contentType("application/json")
	        .body(p1)
	     
		 .when()
		   .put("https://reqres.in/api/users/2")  // passing request
		  
		 .then()
		 .statusCode(200)
	       .log().body();
  }
  
  
  @Test (priority=2)
  public void patchRequest_update()     //  , patch - partial update
  {
	  System.out.println("patch request is executing");
	  // Endpoint - https://reqres.in/api/users/2
	  
	  // creat data/object
	  pojoDemo p1 = new pojoDemo();
	  p1.setName("Kumar");
	  p1.setJob("Teacher");
	  

	     given()  
	      .contentType("application/json")
	        .body(p1)
	     
		 .when()
		   .patch("https://reqres.in/api/users/2")  // passing request
		  
		 .then()
		 .statusCode(200)
	       .log().body();
  }
  
  

  @Test (priority=3)
  public void deleteRequest_update()   
  {
	  System.out.println("delete request is executing");
	  
	  // Endpoint - https://reqres.in/api/users/2
	  
	  
	     given()  
	      
		 .when()
		   .delete("https://reqres.in/api/users/2")  // passing request
		  
		 .then()
		 .statusCode(204)
	       .log().body();
  }
}

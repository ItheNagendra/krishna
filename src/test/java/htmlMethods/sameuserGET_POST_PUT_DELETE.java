package htmlMethods;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;



public class sameuserGET_POST_PUT_DELETE {
	
	
	
	
	String id;
  @Test (priority=1)
  public void  createUser() 
  {
	// creat data/object
	  pojoDemo pojo = new pojoDemo();
	  pojo.setName("Vishal");
	  pojo.setJob("tester");
	  

	    id=given()     // save response in variable
	     .contentType("application/json")   // header - passing data is not impotant but passing it in form of json is important thats y containsType is given
	     .body(pojo)
	 	  
	 	 .when()
	 	 .post("https://reqres.in/api/users")
	 	  .jsonPath().get("id");
	    
	    System.out.println("user is created with id:"+ id);
	 	 
	 }
  
   
  
  @Test (priority=2)
  public void  getUser() 
  {
	  	    given()
	  	    .when().get("https://reqres.in/api/users/"+id)
	  	     .then().log().body();
	  	    System.out.println("user display with same id :"+id);
  }
  
  
  @Test (priority=3)
  public void  updateUser() 
  {
	  // creat data/object
	  pojoDemo p1 = new pojoDemo();
	  p1.setName("Kumar");
	  p1.setJob("Teacher");
	  

	     given()  
	      .contentType("application/json")
	        .body(p1)
	     
		 .when()
		   .put("https://reqres.in/api/users/"+id)  // passing request
		  
		 .then()
		 .statusCode(200)
	       .log().body();
	     
	     System.out.println("data is updated with same id:"+id);
  
  }
  
  
  @Test (priority=4)
  public void  deleteUser() 
  {
	  given()
	   .when().delete("https://reqres.in/api/users/"+id)
	    .then().statusCode(204);
	  
	  System.out.println("User is deleted with same id:"+id);
	  
  }
 }

  
  
  

  
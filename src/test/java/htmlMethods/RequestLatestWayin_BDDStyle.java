package htmlMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;  // this 3 will support given ,when,then format
import static io.restassured.matcher.RestAssuredMatchers.*;  // these are all static methods to access all class method without creating object
import static org.hamcrest.Matchers.*;

 // new methods for API testing , copy above some packages from thier website

/*
 * given()-prerequisites/initial requirements here we can add
            ( header,request ,payload ,cookies ,Authentication ) 
  
 * when()-for request GET,POST,PUT,DELETE
 
 * then()- for response/ validate 
            ( status code,payload ,body )
 
 */




public class RequestLatestWayin_BDDStyle { 
	

  @Test (enabled=false)
  public void getRequeste01()
  {
	  // Endpoint=https://reqres.in/api/users/2
	  
	  
	  // below writing is in chain fasion , (given().when().then().get();)
	  
	  System.out.println("Single user response");
	  
	  
     given()  // no any precondition
	  
	 .when()
	   .get("https://reqres.in/api/users/2")  // passing request
	  
	 .then()
	    //.assertThat()
	    .statusCode(200)
	        //.body("data.id", equalTo(2))    // checking or validating what is id from list or that is equal to given or not
              .body("data.first_name", equalTo("Janet"))   
	          .log().body();
	        //.log().all();	  
  }
  
  
  
  @Test (enabled=false)
  public void getListofUsers()
  { 
	  
	     given()  // no any precondition
		  
		 .when()
		   .get("https://reqres.in/api/users?page=2")  // passing request
		  
		 .then()
		 .statusCode(200)
		   .body("page", equalTo(2))
		   .body("data.id[2]",equalTo(9))
		   .body("data.first_name[5]",equalTo("Rachel"))
		   
		 
		 .log()
		 .body();   // printed out by using log.
	 	     
  }
  
    //hasitems() - it check all element are in a collection
    //contains()- it check all element are in collection and in a strict order
  
  
  @Test 
  public void getTestMethods()
  { 
	  
	     given()  // no any precondition
		  
		 .when()
		   .get("https://reqres.in/api/users?page=2")  // passing request
		  
		 .then()
		 .statusCode(200)
		// .body("data.id", hasItems(9,8,2,10,11,12))         // order does not matter here only contain matter , (here 2 is not part of this matter - shows failure)
		// .body("data.id", contains(7,8,9,10))                // here all contain and order both matters - passed
		 .body("data.id", contains(7,8,9,10,11,12))  // failed due to incomplete data
		 .log().body();
		
  
  
  
  }
}

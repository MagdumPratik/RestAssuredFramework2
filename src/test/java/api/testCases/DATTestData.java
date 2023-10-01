package api.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endPoints.UserEndPoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DATTestData {
	user userPayload;
	@Test(priority=1, dataProvider="AllData", dataProviderClass=DataProviders.class)
	public void testCreateUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone){
userPayload=new user();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		System.out.println("************Creating User***********");
		Response response=UserEndPoints.createUser(userPayload);
	
		//log response
		response.then().log().body();
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=2)
	public void testGetUserData()
	{
		System.out.println("************Getting User Details***********");
		Response response=UserEndPoints.getUser(this.userPayload.getUsername());
		
		//log response
		response.then().log().body();
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3, dataProvider="UserNamesData", dataProviderClass=DataProviders.class)
	public void testDeleteUserData(String userName)
	{
		System.out.println("************Delete User Details***********");
		Response response=UserEndPoints.deleteUser(userName);
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}

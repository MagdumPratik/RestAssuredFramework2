package api.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.payload.user;
import io.restassured.response.Response;

public class userTest {
	Faker faker;
	user userPayload;
	public static Logger logger;
	
	@BeforeClass
	public void generateTestData()
	{
		logger=logger.getLogger("UserTest");
		PropertyConfigurator.configure("log4j.properties");
		faker=new Faker();
		userPayload=new user();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	@Test(priority=0)
	public void testCreateUser()
	{
		logger.info("************Creating User***********");
		Response response=UserEndPoints.createUser(userPayload);
		
		//log response
		response.then().log().body();
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=1)
	public void testGetUserData()
	{
		logger.info("************Getting User Details***********");
		Response response=UserEndPoints.getUser(this.userPayload.getUsername());
		
		//log response
		response.then().log().body();
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUserData()
	{
		logger.info("************Update User Details***********");
		userPayload.setFirstName(faker.name().firstName());
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		
		//log response
		Response responseAfterUpdate=UserEndPoints.getUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUserData()
	{
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		
		//Validation 
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

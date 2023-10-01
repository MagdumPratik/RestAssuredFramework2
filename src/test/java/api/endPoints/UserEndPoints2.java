package api.endPoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.user;
import api.utilities.ReadConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	static ReadConfig rc=new ReadConfig();
	public static String createUser_url=rc.createLink();
	public static String getData_url=rc.getDataLink();
	public static String updateData_url=rc.updateDataLink();
	public static String deleteData_url=rc.deleteDataLink();
	
	public static Response createUser(user payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		
		.when()
			.post(createUser_url);
		
		return response;
	}
	
	public static Response getUser(String username)
	{
		Response response=given()
		.pathParam("username",username)
		
		.when()
			.get(getData_url);
		
		return response;
	}
	public static Response updateUser(String username,user payload)
	{
		Response res=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
			.when()
				.put(updateData_url);
				
			return res;
	}
	public static Response deleteUser(String username)
	{
		Response response=given()
		.pathParam("username", username)

		.when()
			.delete(deleteData_url);
		
		return response;
	}
	
}

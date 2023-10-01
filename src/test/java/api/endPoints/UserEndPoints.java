package api.endPoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response createUser(user payload)
	{
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		
		.when()
			.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(String username)
	{
		Response response=given()
		.pathParam("username",username)
		
		.when()
			.get(Routes.get_url);
		
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
				.put(Routes.update_url);
				
			return res;
	}
	public static Response deleteUser(String username)
	{
		Response response=given()
		.pathParam("username", username)

		.when()
			.delete(Routes.delete_url);
		
		return response;
	}
	
}

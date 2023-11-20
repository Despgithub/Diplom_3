package helpers;

import io.restassured.response.Response;
import model.CreateUserResponse;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserHelper {

    public static CreateUserResponse userDeserialization(Response response) {
        return response.then().assertThat().body("success", equalTo(true)).statusCode(SC_OK).log().all().and().extract().as(CreateUserResponse.class);
    }
}

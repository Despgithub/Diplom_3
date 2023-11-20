package helpers;

import com.github.javafaker.Faker;
import model.CreateUserRequest;

public class DataGenerator {
    public static CreateUserRequest getUser() {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String name = faker.name().firstName();
        String password = faker.internet().password();
        return new CreateUserRequest(email, name, password);
    }
}

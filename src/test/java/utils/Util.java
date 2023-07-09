package utils;

import com.github.javafaker.Faker;

public class Util {

    private static Faker faker;
    private static String validEmail = "olagasich@gmail.com";
    private static String validPassword = "Pwd1122334455";


    public Util(Faker faker){
        this.faker = faker;
    }

    public static String generateFakeEmail(){
        faker = new Faker();
        String fakeEmail = faker.internet().emailAddress();
        return fakeEmail;
    }

    public static String generateFakePassword(){
        faker = new Faker();
        String fakePassword = faker.internet().password();
        return fakePassword;
    }

    public static String getValidEmail() {
        return validEmail;
    }

    public static String getValidPassword() {
        return validPassword;
    }
}

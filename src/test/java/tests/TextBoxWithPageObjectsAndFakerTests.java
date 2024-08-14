package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Date;
import java.util.Locale;

public class TextBoxWithPageObjectsAndFakerTests extends TestBase  {

RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {

        Faker faker = new Faker(new Locale("en-GB"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String gender = faker.options().
                option("Male", "Female", "Other");
        String userNumber = faker.number().digits(10);
     //   Date dateOfBirth = faker.date().birthday();
        String subjects = faker.options().
                option("Maths", "Physics", "Chemistry", "Computer Science", "Economics", "Arts", "Social Studies", "History", "Civics");
        String hobbies = faker.options().
                option("Sports", "Reading", "Music");
        String picture = "cat.jpg";
        String state = "NCR";
        String city = "Delhi";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
          //      .setDateOfBirth(dateOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(streetAddress)
                .setStateAndCity(state,city)

                .submit()

                .checkTableSize(10)

                .checkResult(firstName)
                .checkResult(lastName)
                .checkResult(userEmail)
                .checkResult(gender)
                .checkResult(userNumber)
            //    .checkResult("02 January,1986")
                .checkResult(subjects)
                .checkResult(hobbies)
                .checkResult(picture)
                .checkResult(streetAddress)
                .checkResult(state)
                .checkResult(city);
    }

}
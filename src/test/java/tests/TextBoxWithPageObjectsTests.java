package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class TextBoxWithPageObjectsTests extends TestBase  {

RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Albina")
                .setLastName("Dobrova")
                .setUserEmail("rezolventa86@rambler.ru")
                .setGender("Female")
                .setUserNumber("9872552206")
                .setDateOfBirth("2", "January", "1986")
                .setSubjects("Comp")
                .setHobbies("Sports", "Reading")
                .setPicture("cat.jpg")
                .setCurrentAddress("Ufa, Russia")
                .setStateAndCity("NCR", "Delhi")

                .submit()

                .checkTableSize(10)

                .checkResult("Albina Dobrova")
                .checkResult("rezolventa86@rambler.ru")
                .checkResult("Female")
                .checkResult("9872552206")
                .checkResult("02 January,1986")
                .checkResult("Computer Science")
                .checkResult("Sports, Reading")
                .checkResult("cat.jpg")
                .checkResult("Ufa, Russia")
                .checkResult("NCR Delhi");
    }

    @Test
    void fillMinimumFormTest() {
        registrationPage.openPage()
                .setFirstName("Albina")
                .setLastName("Dobrova")
                .setGender("Female")
                .setUserNumber("9872552206")

                .submit()

                .checkResult("Albina Dobrova")
                .checkResult("Female")
                .checkResult("9872552206")
                .checkResult("06 August,2024");
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .submit()
                .checkValidate();
         }

}
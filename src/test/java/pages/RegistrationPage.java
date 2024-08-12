package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private final SelenideElement firstNameInput = $("#firstName"),
           lastNameInput = $("#lastName"),
           userEmailInput = $("#userEmail"),
           genderWrapper = $("#genterWrapper"),
           userNumberInput = $("#userNumber"),
           calendarInput = $("#dateOfBirthInput"),
           subjectsInput = $("#subjectsInput"),
           hobbiesWrapper = $("#hobbiesWrapper"),
           pictureInput = $("#uploadPicture"),
           currentAddressInput = $("#currentAddress"),
           stateInput = $("#state"),
           cityInput = $("#city"),
           stateCityWrapper = $("#stateCity-wrapper"),
           submitButton = $( "#submit");

   private final ElementsCollection table = $$("[class~=table] tbody tr");
   public String redFields = "rgba(220, 53, 69, 1)";




    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();


   public RegistrationPage openPage() {

        open("/automation-practice-form");

        //после открытия страницы скрываем рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public RegistrationPage setFirstName(String value) {

        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {

        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {

        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {

        genderWrapper.$(byText(value)).click();
        return this;

    }

    public RegistrationPage setUserNumber(String value) {

        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {

        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobby1, String hobby2) {

        hobbiesWrapper.$(byText(hobby1)).click();
        hobbiesWrapper.$(byText(hobby2)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {

        pictureInput.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {

        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {

        stateInput.click();
        stateCityWrapper.$(byText(state)).click();

        cityInput.click();
        stateCityWrapper.$(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {

        submitButton.click();
        return this;
    }

    public RegistrationPage checkTableSize(int value) {

        table.shouldHave(size(value));
        return this;
    }

    public RegistrationPage checkResult(String value) {
        resultComponent.checkTable(value);
        return this;
    }

    public RegistrationPage checkValidate() {
        firstNameInput.shouldHave(cssValue("border-bottom-color", redFields));
        lastNameInput.shouldHave(cssValue("border-bottom-color", redFields));
        userNumberInput.shouldHave(cssValue("border-bottom-color", redFields));
        return this;
    }

}

package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class TextBoxWithTestDataTests extends TestBase {

//        String firstName="Albina",
//                lastName="Dobrova",
//                userEmail="rezolventa86@rambler.ru";


    @Test
    void fillFormTest() {
//        String firstName="Albina",
//                lastName="Dobrova",
//                userEmail="rezolventa86@rambler.ru";

        open("/automation-practice-form");

        //после открытия страницы скрываем рекламу и футер
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        //заполняем таблицу
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Female")).click();                //здесь выбор пола
        $("#userNumber").setValue("9872552206");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--002").click();


        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();


        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("Ufa, Russia");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();



        $("#submit").click();

        //проверка на все заполненные поля в финальной таблице
        //проверим, что полей всего 10
        $$("[class~=table] tbody tr").shouldHave(size(10));

        //проверка на все заполненные поля в финальной таблице
        $(".modal-content").shouldHave(text(firstName));
        $(".modal-content").shouldHave(text(lastName));
        $(".modal-content").shouldHave(text(userEmail));
        $(".modal-content").shouldHave(text("Female"));
        $(".modal-content").shouldHave(text("9872552206"));
        $(".modal-content").shouldHave(text("02 January,1986"));
        $(".modal-content").shouldHave(text("Computer Science"));
        $(".modal-content").shouldHave(text("Sports, Reading"));
        $(".modal-content").shouldHave(text("cat.jpg"));
        $(".modal-content").shouldHave(text("Ufa, Russia"));
        $(".modal-content").shouldHave(text("NCR Delhi"));






    }


}
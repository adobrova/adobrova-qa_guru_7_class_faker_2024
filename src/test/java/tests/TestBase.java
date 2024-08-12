package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
//    public static String firstName="Albina",
//            lastName="Dobrova",
//            userEmail="rezolventa86@rambler.ru";


    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1980x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

        // перед коммитом удалить/закомментировать/поменять на false
        // при удалённом запуске тестов - браузер останется висеть открытым и будет занимать ресурсы
        Configuration.holdBrowserOpen = true;
    }
}

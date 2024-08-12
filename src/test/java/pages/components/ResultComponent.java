package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    public ResultComponent checkTable(String value) {
        $(".modal-content").shouldHave(text(value));
return this;
    }
}
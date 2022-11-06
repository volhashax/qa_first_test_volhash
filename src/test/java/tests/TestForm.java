package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulTest() {

        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(ValuesForForms.name);
        $("[id=userEmail]").setValue(ValuesForForms.email);
        $("[id=currentAddress]").setValue(ValuesForForms.currentAddress);
        $("[id=permanentAddress]").setValue(ValuesForForms.permanentAddress);
        $("[id=submit]").click();

        $("[id=output]").shouldHave(
                text(ValuesForForms.name),
                text(ValuesForForms.email),
                text(ValuesForForms.currentAddress),
                text(ValuesForForms.permanentAddress)
        );

        System.out.println("HAPPY TESTING");
    }
}
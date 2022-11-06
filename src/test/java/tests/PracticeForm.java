package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

    public class PracticeForm {
            @BeforeAll
            static void beforeAll(){
                    Configuration.baseUrl = "https://demoqa.com";
                    Configuration.browserSize = "1920x1080";
            }



        @Test
        @DisplayName("Successful Tests")
        void successfulTest (){


                open("/automation-practice-form");
                executeJavaScript("$('footer').remove()");
                executeJavaScript("$('#fixedban').remove()");


                $("[id=firstName]").setValue("hanna");
                $("[id=lastName]").setValue("LastName");
                $("[id=userEmail]").setValue("hanna77@mail.com");
                $("#genterWrapper").$(byText("Female")).click();
                $("[id=userNumber]").setValue("1234567891");
                $("[id=currentAddress]").setValue("Minsk address");
                $("#dateOfBirthInput").click();
                $(".react-datepicker__month-select").selectOption("August");
                $(".react-datepicker__year-select").selectOption("1998");
                $("[aria-label = 'Choose Monday, August 10th, 1998']").click();
                $("#subjectsInput").sendKeys("Maths");
                $("#subjectsInput").pressEnter();
                $("#hobbiesWrapper").$(byText("Reading")).click();
                $("#uploadPicture").uploadFile(new File("src/test/resources/Screenshot2.png"));
                $("[id=currentAddress]").setValue("Minsk address");
                $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
                $("[id=react-select-4-input]").setValue("Merrut").pressEnter();
                $("[id=submit]").click();



                $(".table-responsive").shouldHave(
                        text("hanna"),
                        text("hanna98ы@mail.com"),
                        text("Female"),
                        text("1234567891"),
                        text("10 August,1998"),
                        text("Maths"),
                        text("Reading"),
                        text("screenshot.png"),
                        text("Minsk address"),
                        text("Uttar Pradesh Merrut")
                );

        }

}

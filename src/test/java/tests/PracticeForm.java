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
                    Configuration.holdBrowserOpen = true;
            }



        @Test
        @DisplayName("Successful Tests")
        void successfulTest (){


                open("/automation-practice-form");
                executeJavaScript("$('footer').remove()");
                executeJavaScript("$('#fixedban').remove()");


                $("[id=firstName]").setValue(ValuesForForms.name);
                $("[id=lastName]").setValue(ValuesForForms.lastName);
                $("[id=userEmail]").setValue(ValuesForForms.email);

                $("#genterWrapper").$(byText(ValuesForForms.gender)).click();

                $("[id=userNumber]").setValue(ValuesForForms.mobileNumber);


                $("#dateOfBirthInput").click();
                $(".react-datepicker__month-select").selectOption(ValuesForForms.monthOfBirth);
                $(".react-datepicker__year-select").selectOption(ValuesForForms.yearOfBirth);
                $("[aria-label = 'Choose Thursday, December 7th, 1989']").click();

                $("#subjectsInput").sendKeys(ValuesForForms.subject);
                $("#subjectsInput").pressEnter();

                $("#hobbiesWrapper").$(byText(ValuesForForms.hobby)).click();
                $("#uploadPicture").uploadFile(new File("src/test/resources/Screenshot1.png"));
                $("[id=currentAddress]").setValue(ValuesForForms.currentAddress);

                $("[id=react-select-3-input]").setValue(ValuesForForms.state).pressEnter();
                $("[id=react-select-4-input]").setValue(ValuesForForms.city).pressEnter();
                $("[id=submit]").click();



                $(".table-responsive").shouldHave(
                        text(ValuesForForms.name + " " + ValuesForForms.lastName),
                        text(ValuesForForms.email),
                        text(ValuesForForms.gender),
                        text(ValuesForForms.mobileNumber),
                        text("07" + " " + ValuesForForms.monthOfBirth + "," +  ValuesForForms.yearOfBirth),
                        text(ValuesForForms.subject),
                        text("Music"),
                        text("Screenshot1.png"),
                        text(ValuesForForms.currentAddress),
                        text(ValuesForForms.state + " " + ValuesForForms.city)
                );

                System.out.println("Test Passed");
        }

}

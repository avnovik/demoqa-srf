import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaTests {
    @Test
    void fillFormTest() {
        //Configuration.browserSize = "1024x768";
        String link = "https://demoqa.com/automation-practice-form",
                welcomeText = "Student Registration Form",
                firstName = "Frodo",
                lastName = "Bagins",
                email = "test@test.test",
                telephoneNumber = "0123456789",
                subjectInput1 = "b",
                subjectInput2 = "ar",
                uploadFileName = "test.pic.txt",
                address = "Yorkwir 3ii Bugorok - nora №2",
                state = "d",
                city = "Lucknow";

        open(link);
        $(".practice-form-wrapper").shouldHave(text(welcomeText));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("[for='gender-radio-3']").click();
        $("#userNumber").val(telephoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value='5']").click();
        $(".react-datepicker__year-select").$("[value='1955']").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subjectInput1).pressTab();
        $("#subjectsInput").setValue(subjectInput2).pressTab();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath(uploadFileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressTab();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        //verification
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content .modal-body").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(telephoneNumber),
                text(uploadFileName), 
                text(address),
                text(city));
        $("#closeLargeModal").scrollIntoView(true).click();
    }
}

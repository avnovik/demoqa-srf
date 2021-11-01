import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {
    @Test
    void fillFormTest() {
        //Configuration.startMaximized = true;
        String link = "https://demoqa.com/automation-practice-form",
                welcomeText = "Student Registration Form",
                fName = "Frodo",
                sName = "Bagins",
                email = "test@test.test",
                telNum = "0123456789",
                subInput1 = "b",
                subInput2 = "ar",
                uploadFileName = "test.pic.txt",
                address = "Yorkwir 3ii Bugorok - nora №2",
                state = "d",
                city = "Lucknow";

        open(link);
        $(".practice-form-wrapper").shouldHave(text(welcomeText));
        $("#firstName").setValue(fName);
        $("#lastName").setValue(sName);
        $("#userEmail").setValue(email);
        $("[for=\"gender-radio-3\"]").click();
        $("#userNumber").val(telNum);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value=\"5\"]").click();
        $(".react-datepicker__year-select").$("[value=\"1955\"]").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue(subInput1).pressTab();
        $("#subjectsInput").setValue(subInput2).pressTab();
        $("[for=\"hobbies-checkbox-3\"]").click();
        $("#uploadPicture").uploadFromClasspath(uploadFileName);
        $("#currentAddress").setValue(address);
        $("#react-select-3-input").setValue(state).pressTab();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        //verification
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content .modal-body").shouldHave(text(fName), text(sName), text(email), text(telNum),
                text(uploadFileName), text(address), text(city));
        $("#closeLargeModal").scrollIntoView(true).click();
    }
}

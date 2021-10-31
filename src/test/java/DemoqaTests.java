import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTests {
    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));
        $("#firstName").setValue("Frodo");
        $("#lastName").setValue("Bagins");
        $("#userEmail").setValue("test@test.test");
        $("[for=\"gender-radio-3\"]").click();
        $("#userNumber").val("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$("[value=\"5\"]").click();
        $(".react-datepicker__year-select").$("[value=\"1955\"]").click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("b").pressTab();
        $("#subjectsInput").setValue("ar").pressTab();
        $("[for=\"hobbies-checkbox-3\"]").click();
        $("#uploadPicture").uploadFromClasspath("test.pic.txt");
        $("#currentAddress").setValue("Yorkwir 3ii Bugorok - nora №2");
        $("#react-select-3-input").setValue("d").pressTab();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();




        sleep(2000);

    }


}

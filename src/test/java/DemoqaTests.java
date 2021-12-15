import data.TestData;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DemoqaTests extends TestBase {

    @Test
    @Owner("novikovav")
    @Feature("Регистрация нового пользователя")
    @Link(name = "DEMOQA", url = "https://demoqa.com/automation-practice-form")
    void fillFormTest() {

        registrationPage
                .openPage()
                .hideBanner()
                .typeFirstName(TestData.firstName)
                .typeLastName(TestData.lastName)
                .typeEmail(TestData.email)
                .typeGender(TestData.gender)
                .typeTelNumber(TestData.telephoneNumber)
                .setDate("05", "June", "1977")
                .typeSubjects(TestData.subjectInput1, TestData.subjectInput2)
                .setHobbies(TestData.hobbies);
          //      .uploadFile(TestData.uploadFileName)
        step("Upload image", () ->
                $("#uploadPicture").uploadFromClasspath(TestData.uploadFileName));

        registrationPage.typeAddress(TestData.address)
                .setStateAndCity("Uttar Pradesh", "Agra")
                .pushSubmitBtn();

        verificationPage
                .verificationTextForm()
                .softAssertForm()
                .closeTextForm();
    }
}

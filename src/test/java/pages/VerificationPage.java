package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.TestData;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;

public class VerificationPage {
    final String
            VERIFICATION_TITLE = "Thanks for submitting the form";

    private final SelenideElement
            verificationText = $("#example-modal-sizes-title-lg"),
            closeModal = $("#closeLargeModal");

    public VerificationPage verificationTextForm() {
        verificationText.shouldHave(text(VERIFICATION_TITLE));
        return this;
    }

    @Step("Проверка введенных данных")
    public VerificationPage softAssertForm() {
        ElementsCollection lines = $$(".table-responsive tbody tr").snapshot();
        SoftAssertions softly = new SoftAssertions();

        for (SelenideElement line : lines) {
            String key = line.$("td").text(); // Student Name
            String expectedValue = TestData.expectedData.get(key);
            String actualValue = line.$("td", 1).text();

            softly.assertThat(actualValue)
                    .as(format("Result in line %s was %s, but expected %s", key, expectedValue, actualValue))
                    .isEqualTo(expectedValue);
        }
        softly.assertAll();

        return this;
    }

    public void closeTextForm() {
        closeModal.scrollIntoView(true).click();
    }

}



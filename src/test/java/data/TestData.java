package data;

import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class TestData {
    static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            telephoneNumber = faker.phoneNumber().subscriberNumber(10),
            subjectInput1 = "Biology",
            subjectInput2 = "Arts",
            hobbies = "Music",
            uploadFileName = "test.pic.txt",
            address = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Agra";

    public static Map<String, String> expectedData = new HashMap<String, String>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", email);
        put("Gender", gender);
        put("Mobile", telephoneNumber);
        put("Date of Birth", "05 June,1977");
        put("Subjects", subjectInput1 + ", " + subjectInput2);
        put("Hobbies", hobbies);
        put("Picture", uploadFileName);
        put("Address", address);
        put("State and City", state + " " + city);
    }};

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public static byte[] getScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

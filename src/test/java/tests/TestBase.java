package tests;

import com.codeborne.selenide.Configuration;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.pages.RegistrationPage;
import tests.pages.VerificationPage;

public class TestBase {

    protected RegistrationPage registrationPage = new RegistrationPage();
    protected VerificationPage verificationPage = new VerificationPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}

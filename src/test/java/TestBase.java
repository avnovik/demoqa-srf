import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.VerificationPage;

public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    VerificationPage verificationPage = new VerificationPage();

    @BeforeAll
    static void beforeAll() {
        //Configuration.browserSize = "800x600";
    }
}

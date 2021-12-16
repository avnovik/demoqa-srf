package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import tests.pages.components.CalendarComponent;
import tests.pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    final String
            LINK = "https://demoqa.com/automation-practice-form",
            FORM_TITLE = "Student Registration Form";

    private final SelenideElement
            welcomeFormProof = $(".practice-form-wrapper"),
            hideBanner = $("#close-fixedban"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#genterWrapper"),
            telNumInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            fileUploadSelect = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress");

    // public CalendarComponent calendar = new CalendarComponent();
    //public StateAndCityComponent stateandcity = new StateAndCityComponent();


    @Step("Открываем страницу регистрации")
    public RegistrationPage openPage() {
        open(LINK);
        welcomeFormProof.shouldHave(text(FORM_TITLE));
        return this;
    }
    @Step("Скрываем нижний баннер")
    public RegistrationPage hideBanner() {
        hideBanner.click();
        return this;
    }
    @Step("Вводим ИМЯ: {firstName}")
    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step(("Вводим ФАМИЛИЮ: {lastName}"))
    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Вводим EMAIL: {email}")
    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Выбираем ПОЛ: {gender}")
    public RegistrationPage typeGender(String gender) {
        genderRadio.$(byText(gender)).click();
        return this;
    }
    @Step("Вводим телефонный номер: {telNumber}")
    public RegistrationPage typeTelNumber(String telNumber) {
        telNumInput.val(telNumber);
        return this;
    }
    @Step("Вводим дату рождения: {day} {month} {year}")
    public RegistrationPage setDate(String day, String month, String year) {
        new CalendarComponent().setDate(day, month, year);
        return this;
    }
    @Step("Выбираем название предмета: {subject1} и {subject2}")
    public RegistrationPage typeSubjects(String subject1, String subject2) {
        subjectInput.setValue(subject1).pressTab();
        subjectInput.setValue(subject2).pressTab();
        return this;
    }
    @Step("Выбираем хобби: {hobby}")
    public RegistrationPage setHobbies(String hobby) {
        $(byText(hobby)).click();
        return this;
    }
    @Step("Загружаем файл")
    public RegistrationPage uploadFile(String fileName) {
        fileUploadSelect.uploadFromClasspath(fileName);
        return this;
    }
    @Step("Вводим адрес")
    public RegistrationPage typeAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    @Step("Выбираем штат: {state} и город: {city} ")
    public RegistrationPage setStateAndCity(String state, String city) {
        new StateAndCityComponent().setStateAndCity(state, city);
        return this;
    }
    @Step("Нажимаем кнопку SUBMIT")
    public void pushSubmitBtn() {
        $("#submit").click();
    }
}

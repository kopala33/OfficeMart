package StepObject;
import PageObject.FormInputPageObject;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.support.Color;

import java.time.Duration;
import static com.codeborne.selenide.Condition.*;


public class FormInputPageSteps extends FormInputPageObject {

    @Step("Personal identification forms")
    public FormInputPageSteps identificationForms() {
        legalForm1.click();
        legalForm1.shouldBe(visible);
        personalForm2.click();
        personalForm2.shouldBe(visible);

        return this;
    }

    public FormInputPageSteps identificationForms1() {
        legalForm1.click();
        submitBtn.click();
        inputCompanyName.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));

        return this;
    }

    @Step("Verify the company name border color is Red")
    public FormInputPageSteps verifyCompanyNameFieldTurnsRed() {
        String redBorder = inputCompanyName.getCssValue("border-color");
        System.out.println(redBorder);
        String hex = Color.fromString(redBorder).asHex().toUpperCase(); // Convert to uppercase for consistency
        System.out.println(hex);

        return this;
    }
    @Step("Verify the identification code border color must be Red")
    public FormInputPageSteps identificationCode() {
        String identifyCodeCssValue = identifyCode.getCssValue("border-color");
        System.out.println(identifyCodeCssValue);
        String hex = Color.fromString(identifyCodeCssValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("Verify the address input border color is Red")
    public FormInputPageSteps addressInput() {
        String addressCssValue = addressInput.getCssValue("border-color");
        System.out.println(addressCssValue);
        String hex = Color.fromString(addressCssValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("Verify the contact number input border color is Red")
    public FormInputPageSteps contactNumberInput() {
        String contactNumberCssValue = contactNumber.getCssValue("border-color");
        System.out.println(contactNumberCssValue);
        String hex = Color.fromString(contactNumberCssValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("Verify the get order input border color is Red")
    public FormInputPageSteps GetOrder() {
        String getOrderCssValue = getOrder.getCssValue("border-color");
        System.out.println(getOrderCssValue);
        String hex = Color.fromString(getOrderCssValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("Verify the email input border color is Red")
    public FormInputPageSteps EmailInput() {
        String emailInputCssValue = emailInput.getCssValue("border-color");
        System.out.println(emailInputCssValue);
        String hex = Color.fromString(emailInputCssValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("identification forms")
    public FormInputPageSteps CompanyNameInput(String compName) {
        legalForm1.click();
        inputCompanyName.setValue(compName);
        submitBtn.click();
        inputCompanyName.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("Verify the company name is Field")
    public FormInputPageSteps verifyCompanyNameIn() {
        String compNameField = inputCompanyName.getCssValue("border-color");
        System.out.println(compNameField);
        String hex = Color.fromString(compNameField).asHex();

        System.out.println(hex);

        return this;
    }
    @Step("No textual data should be written in the identification code")
    public FormInputPageSteps NoTextualField(String codeIn) {
        legalForm1.click();
        identifyCode.setValue(codeIn).shouldBe(empty);
        submitBtn.click();
        identifyCode.setValue(codeIn).shouldBe(empty,Duration.ofMillis(3000));

        return this;
    }
    @Step("Not enough symbols in the identification code Field")
    public FormInputPageSteps notEnoughSymbols(String codeInput) {
        legalForm1.click();
        identifyCode.setValue(codeInput);
        submitBtn.click();
        identifyCode.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("More symbols in the identification code Field")
    public FormInputPageSteps moreSymbols(String codeInputField) {
        legalForm1.click();
        identifyCode.setValue(codeInputField);
        submitBtn.click();

        return this;
    }
    @Step("correct symbols in the identification code Field")
    public FormInputPageSteps correctSymbols(String codeInField) {
        legalForm1.click();
        identifyCode.setValue(codeInField);
        submitBtn.click();
        identifyCode.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("Verify the identification code Field is correct")
    public FormInputPageSteps CodeIsField() {
        String codeIsField = identifyCode.getCssValue("border-color");
        System.out.println(codeIsField);
        String hex = Color.fromString(codeIsField).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If we enter any value in the field then The field should no longer be red")
    public FormInputPageSteps AddressInput(String addressValue) {
        legalForm1.click();
        addressInput.setValue(addressValue);
        submitBtn.click();
        addressInput.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("when Address value in the field then The field should no longer be red")
    public FormInputPageSteps AddressField() {
        String codeIsField = addressInput.getCssValue("border-color");
        System.out.println(codeIsField);
        String hex = Color.fromString(codeIsField).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If we enter any value in the contact number field should no be visible")
    public FormInputPageSteps ContactNumberInput(String contactValue) {
        legalForm1.click();
        contactNumber.setValue(contactValue).shouldBe(empty);
        submitBtn.click();

        return this;
    }
    @Step("If we enter \"contact number\" with a number less than 9 characters, the field should turn red")
    public FormInputPageSteps incorrectContactNumberIn(String contactInputValue) {
        legalForm1.click();
        contactNumber.setValue(contactInputValue);
        submitBtn.click();
        contactNumber.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));


        return this;
    }
    @Step("incorrect number in the field")
    public FormInputPageSteps incorrectNumber() {
        String incorrectNumberField = contactNumber.getCssValue("border-color");
        System.out.println(incorrectNumberField);
        String hex = Color.fromString(incorrectNumberField).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If we enter 12 characters in the \"contact number\" field, at least 9 characters should be entered")
    public FormInputPageSteps incorrectNumberCharacters(String contactIncorrectValue) {
        legalForm1.click();
        contactNumber.setValue(contactIncorrectValue);
        submitBtn.click();

        return this;
    }
    @Step("If we enter a 9-character numerical value in the field, the field should no longer be red")
    public FormInputPageSteps CorrectNumberCharacters(String contactCorrectValue) {
        legalForm1.click();
        contactNumber.setValue(contactCorrectValue);
        submitBtn.click();

        return this;
    }
    @Step("Correct number in the field")
    public FormInputPageSteps CorrectNumber() {
        String correctNumberField = contactNumber.getCssValue("border-color");
        System.out.println(correctNumberField);
        String hex = Color.fromString(correctNumberField).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("Any value in code less than 5 characters in the field should remain red")
    public FormInputPageSteps lessSymbols(String getOrderValue) {
        legalForm1.click();
        getOrder.setValue(getOrderValue);
        submitBtn.click();
        getOrder.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("Field is less than 5 characters should remain red")
    public FormInputPageSteps CodeIsLass() {
        String getOrderValue = getOrder.getCssValue("border-color");
        System.out.println(getOrderValue);
        String hex = Color.fromString(getOrderValue).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If we enter any value that is more than 5 characters, the field should no longer be red")
    public FormInputPageSteps CorrectSymbolsIn(String getOrderIn) {
        legalForm1.click();
        getOrder.setValue(getOrderIn);
        submitBtn.click();
        getOrder.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));


        return this;
    }
    @Step("Field is more than 5 characters should not be remain red")
    public FormInputPageSteps CodeCorrectIn() {
        String getOrderCss = getOrder.getCssValue("border-color");
        System.out.println(getOrderCss);
        String hex = Color.fromString(getOrderCss).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If you enter a valid email format, the field should no longer be red")
    public FormInputPageSteps CorrectEmail(String getEmailIn) {
        legalForm1.click();
        emailInput.setValue(getEmailIn);
        submitBtn.click();
        emailInput.shouldHave(Condition.cssValue("border-color", "rgb(69, 69, 69)"), Duration.ofMillis(5000));


        return this;
    }
    @Step("If it's valid email format, the field should no longer be red")
    public FormInputPageSteps CorrectEmailIn() {
        String emailCss = emailInput.getCssValue("border-color");
        System.out.println(emailCss);
        String hex = Color.fromString(emailCss).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If you enter a invalid email format, the field should be remain red")
    public FormInputPageSteps incorrectEmail(String IncorrectEmail) {
        legalForm1.click();
        emailInput.setValue(IncorrectEmail);
        submitBtn.click();
        emailInput.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));


        return this;
    }
    @Step("If invalid email format, the field should be remain red")
    public FormInputPageSteps incorrectEmailIn() {
        String invalidEmailCss = emailInput.getCssValue("border-color");
        System.out.println(invalidEmailCss);
        String hex = Color.fromString(invalidEmailCss).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If you enter a invalid email format, the field should be remain red")
    public FormInputPageSteps InvalidEmail(String InvalidEmailIn) {
        legalForm1.click();
        emailInput.setValue(InvalidEmailIn);
        submitBtn.click();
        emailInput.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("If invalid email format, the field should be remain red")
    public FormInputPageSteps invalidEmailIn() {
        String invalidEmailCss = emailInput.getCssValue("border-color");
        System.out.println(invalidEmailCss);
        String hex = Color.fromString(invalidEmailCss).asHex();
        System.out.println(hex);

        return this;
    }
    @Step("If you enter a invalid email format, the field should be remain red")
    public FormInputPageSteps InvalidEmailValue(String InvalidEmail) {
        legalForm1.click();
        emailInput.setValue(InvalidEmail);
        submitBtn.click();
        emailInput.shouldHave(Condition.cssValue("border-color", "rgb(255, 0, 0)"), Duration.ofMillis(5000));

        return this;
    }
    @Step("If invalid email format, the field should be remain red")
    public FormInputPageSteps invalidEmail() {
        String invalidEmailCss = emailInput.getCssValue("border-color");
        System.out.println(invalidEmailCss);
        String hex = Color.fromString(invalidEmailCss).asHex();
        System.out.println(hex);

        return this;
    }

    public boolean isJuridicalPersonFormDisplayed() {
        return false;
    }

    public boolean isPhysicalPersonFormDisplayed() {
        return false;
    }
}

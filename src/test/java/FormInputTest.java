import StepObject.AddInCartPageSteps;
import StepObject.FormInputPageSteps;
import Utills.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.Assert;

import static DataObject.FormInput.*;
import static com.codeborne.selenide.Condition.empty;


public class FormInputTest extends ChromeRunner {

    FormInputPageSteps formInputPageSteps = new FormInputPageSteps();
    AddInCartPageSteps addInCartPageSteps = new AddInCartPageSteps();



    //positive case
    @Test
    @Description("18 case: კალათაში პროდუქტის დამატების შემდეგ გაგრძელება ღილაკზე დაჭერით, უნდა გამოვიდეს ორი ფორმა \"იურიდიული პირები\" და \"ფიზიკური პირები\"")
    @Severity(SeverityLevel.NORMAL)
    public void identificationPersonalForms() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        Assert.assertFalse(addInCartPageSteps.isCartContinueBtnDisplayed(), "CartContinue button is not displayed.");
        formInputPageSteps.identificationForms();
        Assert.assertFalse(formInputPageSteps.isJuridicalPersonFormDisplayed(), "Juridical person form is not displayed.");
        Assert.assertFalse(formInputPageSteps.isPhysicalPersonFormDisplayed(), "Physical person form is not displayed.");
    }

    // negative case
    @Test
    @Description("19 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"კომპანიის სახელწოდება\"")
    @Severity(SeverityLevel.NORMAL)
    public void fillUpForms() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .verifyCompanyNameFieldTurnsRed();
        Assert.assertTrue(formInputPageSteps.inputCompanyName.isDisplayed(),"უნდა გაწითლდეს ველი \"კომპანიის სახელწოდება\"");

    }

    // negative case
    @Test
    @Description("20 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"საიდენტიფიკაციო კოდი\"")
    @Severity(SeverityLevel.NORMAL)
    public void identificationCode() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .identificationCode();
        Assert.assertTrue(formInputPageSteps.identifyCode.isDisplayed(),"უნდა გაწითლდეს ველი \"საიდენტიფიკაციო კოდი\"");
    }

    // negative case
    @Test
    @Description("21 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"ფაქტიური მისამართი\"")
    @Severity(SeverityLevel.NORMAL)
    public void AddressInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .addressInput();
        Assert.assertTrue(formInputPageSteps.addressInput.isDisplayed(),"უნდა გაწითლდეს ველი \"ფაქტიური მისამართი\"");
    }

    // negative case
    @Test
    @Description("22 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"საკონტაქტო ნომერი\"")
    @Severity(SeverityLevel.NORMAL)
    public void contactNumberInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .contactNumberInput();
        Assert.assertTrue(formInputPageSteps.contactNumber.isDisplayed(),"უნდა გაწითლდეს ველი \"საკონტაქტო ნომერი\"");
    }

    // negative case
    @Test
    @Description("23 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"როდის გსურთ შეკვეთის მიღება?\"")
    @Severity(SeverityLevel.NORMAL)
    public void GetOrderInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .GetOrder();
        Assert.assertTrue(formInputPageSteps.getOrder.isDisplayed(),"უნდა გაწითლდეს ველი \"როდის გსურთ შეკვეთის მიღება?\"");
    }

    // negative case
    @Test
    @Description("24 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკების შემთხვევაში, უნდა გაწითლდეს ველი \"ელ.ფოსტა\"")
    @Severity(SeverityLevel.NORMAL)
    public void email_Input() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .EmailInput();
        Assert.assertTrue(formInputPageSteps.emailInput.isDisplayed(),"უნდა გაწითლდეს ველი \"ელ.ფოსტა\"");
    }

    // positive case
    @Test
    @Description("25 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"კომპანიის სახელწოდება\" წითლდება . თუ ველში ჩავწერთ ნებისმიერ მნიშვნელობას და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void compNameInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.identificationForms1()
                .CompanyNameInput(compName)
                .verifyCompanyNameIn();
        Assert.assertTrue(formInputPageSteps.inputCompanyName.isDisplayed(),"თუ ველში ჩავწერთ ნებისმიერ მნიშვნელობას და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი");
    }

    // negative case
    @Test
    @Description("26 case: იურიდიული პირის ფორმაზე ველში \"საიდენტიფიკაციო კოდი\" ტექსტური ტიპის მონაცემის შეყვანისას, არ უნდა ჩაიწეროს ველში მნიშვნელობა")
    @Severity(SeverityLevel.NORMAL)
    public void CodeFieldInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.NoTextualField(codeIn);
        Assert.assertFalse(formInputPageSteps.identifyCode.is(Condition.hidden),"ტექსტური ტიპის მონაცემის შეყვანისას, არ უნდა ჩაიწეროს ველში მნიშვნელობა");

    }

    // negative case
    @Test
    @Description("27 case: იურიდიული პირის ფორმაზე ველში \"საიდენტიფიკაციო კოდი\" თუ შევიყვანთ 11 სიმბოლოზე ნაკლებ რიცხვით მნიშვნელობას და დავაჭერთ გაგზავნა ღილაკს, უნდა გაწითლდეს ველი \"საიდენტიფიკაციო კოდი\"")
    @Severity(SeverityLevel.NORMAL)
    public void NotEnoughSymbols() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.notEnoughSymbols(codeInput)
                .identificationCode();
        Assert.assertTrue(formInputPageSteps.identifyCode.isDisplayed(),"თუ შევიყვანთ 11 სიმბოლოზე ნაკლებ რიცხვით მნიშვნელობას და დავაჭერთ გაგზავნა ღილაკს, უნდა გაწითლდეს ველი \"საიდენტიფიკაციო კოდი\"");

    }

    // negative case
    @Test
    @Description("28 case: იურიდიული პირის ფორმაზე ველში \"საიდენტიფიკაციო კოდი\" თუ შევიყვანთ მაგ 12 სიმბოლს, ველში მაინც უნდა ჩაიწეროს 11 სიმბოლო")
    @Severity(SeverityLevel.NORMAL)
    public void MoreSymbols() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.moreSymbols(codeInputField);
        Assert.assertTrue(formInputPageSteps.identifyCode.isDisplayed(),"თუ შევიყვანთ მაგ 12 სიმბოლს, ველში მაინც უნდა ჩაიწეროს 11 სიმბოლო");

    }

    // positive case
    @Test
    @Description("29 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"საიდენტიფიკაციო კოდი\"  წითლდება . თუ ველში ჩავწერთ რიცხვით მნიშვნელობას(დასაშვებია მხოლოდ 11 სიმბოლო) და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void CorrectSymbols() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.correctSymbols(codeInField)
                .CodeIsField();
        Assert.assertTrue(formInputPageSteps.identifyCode.isDisplayed(),"თუ ველში ჩავწერთ რიცხვით მნიშვნელობას(დასაშვებია მხოლოდ 11 სიმბოლო) და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი");

    }

    // positive case
    @Test
    @Description("30 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"ფაქტიური მისამართი\" წითლდება . თუ ველში ჩავწერთ ნებისმიერ მნიშვნელობას და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void AddressInField() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.AddressInput(addressValue)
                .AddressField();
        Assert.assertTrue(formInputPageSteps.addressInput.isDisplayed(),"თუ ველში ჩავწერთ ნებისმიერ მნიშვნელობას და კვლავ დავაკლიკებთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი");

    }

    // negative case
    @Test
    @Description("31 case: იურიდიული პირის ფორმაზე ველში \"საკონტაქტო ნომერი\" ტექტსური ტიპის მონაცემის შეყვანისას, არ უნდა ჩაიწეროს ველში მნიშვნელობა")
    @Severity(SeverityLevel.NORMAL)
    public void contactNumber() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.ContactNumberInput(contactValue);
        Assert.assertTrue(formInputPageSteps.contactNumber.is(empty),"ტექტსური ტიპის მონაცემის შეყვანისას, არ უნდა ჩაიწეროს ველში მნიშვნელობა");

    }

    // negative case
    @Test
    @Description("32 case: იურიდიული პირის ფორმაზე ველში \"საკონტაქტო ნომერი\" თუ შევიყვანთ 9 სიმბოლოზეზე ნაკლებ რიცხვით მნიშნელობას და დავაჭერთ გაგზავნა ღილაკს, უნდა გაწითლდეს ველი \"საკონტაქტო ნომერი\"")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectContactNumber() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.incorrectContactNumberIn(contactInputValue)
                .incorrectNumber();
        Assert.assertTrue(formInputPageSteps.contactNumber.isDisplayed(),"უნდა გაწითლდეს ველი \"საკონტაქტო ნომერი\"");

    }

    // negative case
    @Test
    @Description("33 case: იურიდიული პირის ფორმაზე ველში \"საკონტაქტო ნომერი\" თუ შევიყვანთ მაგ 12 სიმბოლს, ველში მაინც უნდა ჩაიწეროს 9 სიმბოლო")
    @Severity(SeverityLevel.NORMAL)
    public void IncorrectNumberCharacters() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.incorrectNumberCharacters(contactIncorrectValue);
        Assert.assertTrue(formInputPageSteps.contactNumber.isDisplayed(),"ველში მაინც უნდა ჩაიწეროს 9 სიმბოლო");

    }

    // positive case
    @Test
    @Description("34 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"საკონტაქტო ნომერი\" წითლდება თუ ველში ჩავწერთ 9 სიმბოლოიან რიცხვით მნიშვნელობას და კვლავ დავაჭერთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void CorrectNumberCharacters() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.CorrectNumberCharacters(contactCorrectValue)
                .CorrectNumber();
        Assert.assertTrue(formInputPageSteps.contactNumber.isDisplayed(),"თუ ველში ჩავწერთ 9 სიმბოლოიან რიცხვით მნიშვნელობას და კვლავ დავაჭერთ გაგზავნა ღილაკს, ველი აღარ უნდა იყოს წითელი");

    }

    // negative case
    @Test
    @Description("35 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"როდის გსურთ შეკვეთის მიღება?\" წითლდება თუ ჩავწერთ ნებისმიერ მნიშვნელობას რომელიც 5 სიმბოლოზე ნაკლებია, ველი \"როდის გსურთ შეკვეთის მიღება?\" უნდა დარჩეს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void LassCharacters() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.lessSymbols(getOrderValue)
                .CodeIsLass();
        Assert.assertTrue(formInputPageSteps.getOrder.isDisplayed(),"თუ ჩავწერთ ნებისმიერ მნიშვნელობას რომელიც 5 სიმბოლოზე ნაკლებია, ველი \"როდის გსურთ შეკვეთის მიღება?\" უნდა დარჩეს წითელი");

    }
    // positive case
    @Test
    @Description("36 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"როდის გსურთ შეკვეთის მიღება?\" წითლდება თუ ჩავწერთ ნებისმიერ მნიშვნელობას რომელიც 5 სიმბოლოზე მეტია, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void CorrectSymbolsIn() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.CorrectSymbolsIn(getOrderIn)
                .CodeCorrectIn();
        Assert.assertTrue(formInputPageSteps.getOrder.isDisplayed(),"თუ ჩავწერთ ნებისმიერ მნიშვნელობას რომელიც 5 სიმბოლოზე მეტია, ველი აღარ უნდა იყოს წითელი");

    }

    // positive case
    @Test
    @Description("37 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"ელ.ფოსტა\" წითლდება თუ ჩავწერთ მეილისთვის დასაშვებ ფორმატში მნიშვნელობას test@gmail.com მაგალითად, ველი აღარ უნდა იყოს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void CorrectEmailInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.CorrectEmail(getEmailIn)
                .CorrectEmailIn();
        Assert.assertTrue(formInputPageSteps.emailInput.isDisplayed(),"თუ ჩავწერთ მეილისთვის დასაშვებ ფორმატში მნიშვნელობას test@gmail.com მაგალითად, ველი აღარ უნდა იყოს წითელი");

    }

    /**
     * negativ case
     * bag report არასწორი იმაილის ჩაწერის დროს ველი უნდა წითლდებოდეს:--> (არ წითლდება)
     */
    @Test
    @Description("38 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"ელ.ფოსტა\" წითლდება თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test.gmail.com, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void incorrectEmailInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.incorrectEmail(IncorrectEmail)
                .incorrectEmailIn();
        Assert.assertTrue(formInputPageSteps.emailInput.isDisplayed(),"თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test.gmail.com, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი");

    }

    /**
     * negativ case
     * bag report არასწორი იმაილის ჩაწერის დროს ველი უნდა წითლდებოდეს:--> (არ წითლდება)
     */
    @Test
    @Description("39 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"ელ.ფოსტა\" წითლდება თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test@gmail, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailInput() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.InvalidEmail(InvalidEmailIn)
                .invalidEmailIn();
        Assert.assertTrue(formInputPageSteps.emailInput.isDisplayed(),"თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test@gmail, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი");

    }
    /**
     * negativ case
     * bag report არასწორი იმაილის ჩაწერის დროს ველი უნდა წითლდებოდეს:--> (არ წითლდება)
     */
    @Test
    @Description("40 case: იურიდიულ ფორმაზე არაფრის შევსებისას გაგზავნა ღილაკზე დაკლიკებისას ველი \"ელ.ფოსტა\" წითლდება თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test.gmail@, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი")
    @Severity(SeverityLevel.NORMAL)
    public void invalidEmailValueIn() {
        addInCartPageSteps.addToCart()
                .CartContinueBtn();
        formInputPageSteps.InvalidEmailValue(InvalidEmail)
                .invalidEmail();
        Assert.assertTrue(formInputPageSteps.emailInput.isDisplayed(),"თუ ჩავწერთ მეილისთვის დაუშვებელ ფორმატს test.gmail@, ველი \"ელ.ფოსტა\" უნდა დარჩეს წითელი");

    }

}

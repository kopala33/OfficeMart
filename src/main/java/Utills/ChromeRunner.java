package Utills;

import StepObject.AddInCartPageSteps;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.open;


public class ChromeRunner {

    static AddInCartPageSteps addInCartPageSteps = new AddInCartPageSteps();

    @Parameters("browser")
    @BeforeMethod(description = "Open the browser according to the resolution")
    public static void setUp(@Optional("chrome") String browser) throws InterruptedException {
        Configuration.browserSize = "3840x2160";
        Configuration.headless = false; // Set to true if you want to run tests in the background
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 10000;

        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("Executing on FireFox");
            Configuration.browser = "firefox";
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("Executing on CHROME");
            Configuration.browser = "chrome";
        } else if (browser.equalsIgnoreCase("ie")) {
            System.out.println("Executing on IE");
            Configuration.browser = "ie";
        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }

        open("https://officemart.ge/ge");
        addInCartPageSteps.divModalContentPopUp.doubleClick();
    }

    @AfterMethod(description = "Clear the cache, cookie, local storage and close the browser")
    public void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();

    }

}

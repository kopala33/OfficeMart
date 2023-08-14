package Utills;

import StepObject.AddInCartPageSteps;
import com.codeborne.selenide.*;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class ChromeRunner {

    static AddInCartPageSteps addInCartPageSteps = new AddInCartPageSteps();

    @BeforeMethod(description = "Open the browser according to the resolution")
    public static void setUp() throws InterruptedException {
        Configuration.browserSize = "3840x2160";
        Configuration.headless = true; // Set to true if you want to run tests in the background
        open("https://officemart.ge/ge");
        addInCartPageSteps.divModalContentPopUp.doubleClick();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
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
package StepObject;
import PageObject.SearchPageObject;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Condition.*;


public class SearchPageSteps extends SearchPageObject {

    // positive
    @Step("1 case: Click on search button")
    public SearchPageSteps searchBtnClick() {
        searchBtn.shouldBe(visible).click();

        return this;
    }
    // positive
    @Step("2 case: Input search value is visible")
    public SearchPageSteps SearchValue(String penName) {
        searchBtn.shouldBe(visible).click();
        inputSearch.setValue(penName);
        buttonSearch.shouldBe(visible, Duration.ofMillis(5000)).click();


        return this;
    }
    @Step("Loop, search for all products with the same name")
    public SearchPageSteps countSameName() {
        int searchResults = divForPen.size();
        System.out.println("Number of search results: " + searchResults);

        List<String> productNames = new ArrayList<>();

        for (int i = 0; i < searchResults; i++) {
            SelenideElement searchResult = divForPen.get(i);
            String penName = searchResult.$(".prod_title").getText();
            System.out.println("Pen name " + (i + 1) + ": " + penName);
            productNames.add(penName);
        }

        for (String productName : productNames) {
            Assert.assertTrue(productName.contains("კალამი ბურთულიანი"),"Product name doesn't contain the expected string.");

        }

        return this;
    }

    //Negative
    @Step("3 case: Input search negative value საძიებო სიტყვა'satesto'ვერაფერი მოიძებნა")
    public SearchPageSteps InputSearchNegativeValue(String searchIncorrectValue) {
        searchBtn.shouldBe(visible).click();
        inputSearch.setValue(searchIncorrectValue);
        buttonSearch.click();
        Satesto.shouldBe(visible);

        return this;

    }
    public boolean isSearchButtonDisplayed() {
        return searchBtn.isDisplayed();
    }
    public long getSearchInputValue() {
        return inputSearch.getValue().length();
    }

}

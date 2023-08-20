import StepObject.SearchPageSteps;
import Utills.ChromeRunner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.SearchForProduct.penName;
import static DataObject.SearchForProduct.searchIncorrectValue;

public class SearchTest extends ChromeRunner {

    SearchPageSteps searchPageSteps = new SearchPageSteps();
    SoftAssert softAssert = new SoftAssert();

    @Test
    @Description("1 case: საძიებო ღილაკზე დაკლიკებით უნდა გამოვიდეს ჩასაწერი ველი, გამოდის ჩასაწერი ველი")
    @Severity(SeverityLevel.NORMAL)
    public void SearchButtonClick() {
        searchPageSteps.searchBtnClick();
        softAssert.assertTrue(searchPageSteps.isSearchButtonDisplayed());
        softAssert.assertAll();
    }

    @Test
    @Description("2 case: საძიებო ველში სწორი მონაცემებით ძებნა (მაგ: კალამი ბურთულიანი), დაბრუნებული მონაცემების სახელებში უნდა იყოს ძებნისას გადაცემული სიტყვა")
    @Severity(SeverityLevel.NORMAL)
    public void searchProductByName() {
        searchPageSteps.SearchValue(penName)
                .countSameName();


    }

    @Test
    @Description("3 case: საძიებო ველში არასწორი მონაცემებით ძებნა (მაგ: satesto), უნდა გამოიტანოს შედეგი ტექსტით: \"საძიებო სიტყვა 'satesto' ვერაფერი მოიძებნა\"")
    @Severity(SeverityLevel.NORMAL)
    public void negativeInputValue() {
        searchPageSteps.InputSearchNegativeValue(searchIncorrectValue);
        softAssert.assertNotEquals(searchPageSteps.getSearchInputValue(), "Input of this value must not be found");
        softAssert.assertAll();
    }


}

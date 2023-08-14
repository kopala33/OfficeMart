package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPageObject {

    public SelenideElement searchBtn = $(byText("პროდუქტის ძიება"));
    public SelenideElement inputSearch = $(byName("search"));
    public SelenideElement buttonSearch = $("button.search_button");
    public SelenideElement Satesto = $("h4");
    public ElementsCollection divForPen = $$("div.item");
    public SelenideElement penByName = $("h4");
    public SelenideElement penTitle = $(".prod_title");







   
    


    

    
    
}

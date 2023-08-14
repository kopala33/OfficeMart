package PageObject;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AddInCartPageObject {

    // search product 
    public SelenideElement searchBtn = $(byText("პროდუქტის ძიება"));
    public SelenideElement inputSearch = $(byName("search"));
    public SelenideElement iSearchBtn = $(".search_button");
    public SelenideElement addCartBtn = $(byAttribute("onclick","updateCartItemColor(1435)"));
    public SelenideElement addCartPopUp = $(byText("პროდუქტი წარმატებით დაემატა კალათაში"));
    public SelenideElement insideCart = $(".cart_info");

    // add to cart
    public SelenideElement itemTitle = $(".item_title");
    public SelenideElement itemColor = $(".color");
    public SelenideElement itemCode = $(".item_id");
    public SelenideElement itemQuantity = $(byName("quantity"));
    public SelenideElement itemPrice = $(".prod_price",0);
    public SelenideElement itemTotalPrice = $(".fullPriceFor");
    public SelenideElement addSecondItem = $(byAttribute("onclick","updateCartItemColor(1488)"));

    // add item quantity in the cart plus and minus button
    public SelenideElement plusBtn = $(".fa-plus");
    public SelenideElement minusBtn = $("i.fa.fa-minus");

    // delete item form cart
    public SelenideElement deleteTimesFromCart = $("i.fas.fa-times");
    public SelenideElement deleteAllItemsFromCartBtn = $(byText("კალათის გასუფთავება"));
    public SelenideElement cartIsEmptyText = $(byText("კალათა ცარიელია"));
    public SelenideElement cartContinueButton = $(".continue");

    // for chromeRunner setUp
    public SelenideElement divModalContentPopUp = $(".page_header");
















    
    
    
    








  








    





    


    
    











    
    
    




}

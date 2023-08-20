import StepObject.AddInCartPageSteps;
import Utills.ChromeRunner;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AddInToCartTest extends ChromeRunner {

    AddInCartPageSteps addInCartPageSteps = new AddInCartPageSteps();

    //positive case
    @Test
    @Description("4 case: კონკრეტული პროდუქტის კალათაში დამატების ღილაკზე დაჭერით, უნდა გამოიტანოს შედეგი შეტყობინება: \"პროდუქტი წარმატებით დაემატა კალათაში\" ")
    @Severity(SeverityLevel.NORMAL)
    public void addProductInToCartTest() {
        addInCartPageSteps.addToCart();
        Assert.assertFalse(addInCartPageSteps.addToCart().addCartBtn.isDisplayed(),"addCartBtn is not displayed");
    }

    //positive case
    @Test
    @Description("5 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის დასახელება")
    @Severity(SeverityLevel.NORMAL)
    public void productionName() {
        addInCartPageSteps.addToCart()
                        .ItemTitle();
        Assert.assertTrue(addInCartPageSteps.itemTitle.isDisplayed(),"პროდუქტის სახელი უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("6 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის ფერი")
    @Severity(SeverityLevel.NORMAL)
    public void productionColor() {
        addInCartPageSteps.addToCart()
                .ItemColor();
        Assert.assertTrue(addInCartPageSteps.itemColor.isDisplayed(),"პროდუქტის ფერი უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("7 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის კოდი")
    @Severity(SeverityLevel.NORMAL)
    public void productionCode() {
        addInCartPageSteps.addToCart()
                .ItemCode();
        Assert.assertTrue(addInCartPageSteps.itemCode.isDisplayed(),"პროდუქტის კოდი უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("8 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის რაოდენობა")
    @Severity(SeverityLevel.NORMAL)
    public void productionItemQuantity() {
        addInCartPageSteps.addToCart()
                .ItemQuantity();
        Assert.assertTrue(addInCartPageSteps.itemQuantity.isDisplayed(),"პროდუქტის როდენობა უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("9 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის ფასი")
    @Severity(SeverityLevel.NORMAL)
    public void productionItemPrice() {
        addInCartPageSteps.addToCart()
                .ItemPrice();
        Assert.assertTrue(addInCartPageSteps.itemPrice.isDisplayed(),"პროდუქტის ფასი უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("10 case: პროდუქტის დამატების შემდეგ კალათაში გადასვლისას უნდა ჩანდეს, დამატებული პროდუქტის ჯამი ( \"სულ)")
    @Severity(SeverityLevel.NORMAL)
    public void productionItemCountPrice() {
        addInCartPageSteps.addToCart()
                .ItemTotalPrice();
        Assert.assertTrue(addInCartPageSteps.itemTotalPrice.isDisplayed(),"პროდუქტის მთლიანი ფასის ჯამი უნდა ჩანდეს");
    }

    //positive case
    @Test
    @Description("11 case: თუ გავზრდით კალათაში არსებული პროუქტის რაოდენობას პროპორციულად უნდა გაიზარდოს თითოეული ველის \"სულ\" მნიშვნელობა, მაგ: თუ პროდუქტი ღირს 0.75 და რაოდენობა გავხადეთ 2. \"სულ\" ველში უნდა ჩანდეს 1.5 ")
    @Severity(SeverityLevel.NORMAL)
    public void productionItemCountDoublePrice() {
        addInCartPageSteps.addToCart()
                .PlusBtn()
                .validateTotalPrice();
    }

    //positive case
    @Test
    @Description("12 case: თუ შევამცირებთ კალათაში არსებული პროუქტის რაოდენობას პროპორციულად უნდა შემცირდეს თითოეული ველის \"სულ\" მნიშვნელობა, მაგ: თუ პროდუქტი ღირს 0.75 და არჩეული გვაქს რაოდენობა 2 შემცირების ღილაკზე დაჭერის შემდეგ უნდა გამოიტანოს 0.75")
    @Severity(SeverityLevel.NORMAL)
    public void reduceQuantityPrice() {
        addInCartPageSteps.addToCart()
                .MinusBtn()
                .reduceQuantityPrice();
    }

    //positive case
    @Test
    @Description("13 case: შესაძლებელი უნდა იყოს კალათაში არსებული კონკრეტული პროდუქტის წაშლა, \"X\" ღილაკზე დაჭერით, პროდუქტი ქრება კალათიდან")
    @Severity(SeverityLevel.NORMAL)
    public void DeleteFromCart() {
        addInCartPageSteps.addToCart()
                .DeleteTimesFromCart();
        Assert.assertTrue(addInCartPageSteps.insideCart.isEnabled());
    }

    //positive case
    @Test
    @Description("14 case: თუ რამდენიმე პროდუქტი გვაქვს კალათაში დამატებული შესაძლებელი უნდა იყოს მთლიანი კალათის გასუფთავება, \"კალათის გასუფთავება\" ღილაკზე დაჭერით ყველა პროდუქტი ქრება კალათიდან")
    @Severity(SeverityLevel.NORMAL)
    public void addSecondItemToCart() {
        addInCartPageSteps.addToCart()
                .addSecondItemToCart()
                .DeleteAllItemsFromCartBtn();
        Assert.assertFalse(addInCartPageSteps.deleteAllItemsFromCartBtn.exists(),"კალათიდან ყველა პროდუქტის წაშლის შემდეგ, წაშლის ღილაკი აღარ უნდა ჩანდეს ");
    }

    //positive case
    @Test
    @Description("15 case: თუ რამდენიმე პროდუქტი გვაქვს კალათაში დამატებული შესაძლებელი უნდა იყოს მთლიანი კალათის გასუფთავება, \"კალათის გასუფთავება\" ღილაკზე დაჭერით გამოდის ტექსტი კალათა ცარიელია")
    @Severity(SeverityLevel.NORMAL)
    public void CartEmpty() {
        addInCartPageSteps.addToCart()
                .addSecondItemToCart()
                .DeleteAllItemsFromCartBtn()
                .CartIsEmptyText();
        Assert.assertTrue(addInCartPageSteps.cartIsEmptyText.isDisplayed(),"ღილაკზე დაჭერით გამოდის ტექსტი კალათა ცარიელია");
    }

    //positive case
    @Test
    @Description("16 case: თუ რამდენიმე პროდუქტი გვაქვს კალათაში დამატებული შესაძლებელი უნდა იყოს მთლიანი კალათის გასუფთავება, \"კალათის გასუფთავება\" ღილაკზე დაჭერით უნდა გაქრეს ღილაკი \"გაგრძელება\"")
    @Severity(SeverityLevel.NORMAL)
    public void CartContinueButton() {
        addInCartPageSteps.addToCart()
                .addSecondItemToCart()
                .DeleteAllItemsFromCartBtn()
                .CartIsEmptyText()
                .CartContinueButton();
        Assert.assertFalse(addInCartPageSteps.cartContinueButton.isDisplayed(),"გაგრძელების ღილაკი არ უნდა ჩანდეს ");
    }

    //positive case
    @Test
    @Description("17 case: თუ რამდენიმე პროდუქტი გვაქვს კალათაში დამატებული შესაძლებელი უნდა იყოს მთლიანი კალათის გასუფთავება, \"კალათის გასუფთავება\" ღილაკზე დაჭერით უნდა გაქრეს ღილაკი \"კალათის გასუფთავება\"")
    @Severity(SeverityLevel.NORMAL)
    public void cleanUpCartBtn() {
        addInCartPageSteps.addToCart()
                .addSecondItemToCart()
                .DeleteAllItemsFromCartBtn()
                .CartIsEmptyText()
                .CartContinueButton()
                .DeleteAllItemsCartBtn();
        Assert.assertFalse(addInCartPageSteps.deleteAllItemsFromCartBtn.isDisplayed(),"ღილაკზე დაჭერით უნდა გაქრეს ღილაკი \"კალათის გასუფთავება\"");
    }


}


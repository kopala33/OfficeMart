package StepObject;
import PageObject.AddInCartPageObject;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.math.BigDecimal;
import java.time.Duration;
import static com.codeborne.selenide.Condition.visible;


public class AddInCartPageSteps extends AddInCartPageObject {

    // positive
    @Step("Search for a product and add in to the cart: bag repost: პროდუქტის დამეტების დროს კალათაში გარედან არ ჩანს რაოდენობა და ფასი")
    public AddInCartPageSteps addToCart() {
        searchBtn.click();
        inputSearch.setValue("კალამი ბურთულიანი");
        iSearchBtn.click();
        addCartBtn.click();
        addCartPopUp.shouldBe(visible, Duration.ofMillis(5000));
        insideCart.click();

        return this;
    }

    @Step("Product Name")
    public AddInCartPageSteps ItemTitle() {
        itemTitle.shouldBe(visible);

        return this;
    }

    @Step("Product color")
    public AddInCartPageSteps ItemColor() {
        itemColor.shouldBe(visible);

        return this;
    }

    @Step("Item code")
    public AddInCartPageSteps ItemCode() {
        itemCode.shouldBe(visible);

        return this;
    }

    @Step("Item quantity")
    public AddInCartPageSteps ItemQuantity() {
        itemQuantity.shouldBe(visible);

        return this;
    }

    @Step("Item price")
    public AddInCartPageSteps ItemPrice() {
        itemPrice.shouldBe(visible);

        return this;
    }

    @Step("Item total price")
    public AddInCartPageSteps ItemTotalPrice() {
        itemTotalPrice.shouldBe(visible);

        return this;
    }

    @Step("Item total price")
    public AddInCartPageSteps PlusBtn() {
        plusBtn.click();

        return this;
    }

    /**
     * ამოწმებს ნივთების მთლიან ფასს.
     *
     * ეს მეთოდი ამრავლებს ნივთის ფასს რაოდენობაზე და ადარებს გამოტანილ მთლიან ფასს.
     * თუ რაოდენობა 1-ზე მეტია, ის ითვლის მოსალოდნელ მთლიან ფასს საქონლის ფასის რაოდენობაზე გამრავლებით,
     * და შემდეგ ამტკიცებს, რომ მოსალოდნელი ჯამური ფასი ემთხვევა რეალურ მთლიან ფასს.
     *
     */
    @Step("count multiply price of items")
    public AddInCartPageSteps validateTotalPrice() {
        String itemPriceText = itemPrice.getText();
        String itemQuantityValue = itemQuantity.getValue();
        String itemTotalPriceText = itemTotalPrice.getText();

        BigDecimal itemPrice = new BigDecimal(itemPriceText.replaceAll("[^\\d.]", ""));
        int itemQuantity = Integer.parseInt(itemQuantityValue);
        BigDecimal totalPrice = new BigDecimal(itemTotalPriceText.replaceAll("[^\\d.]", ""));

        System.out.println(itemPrice);
        System.out.println(itemQuantity);
        System.out.println(totalPrice);

        if (itemQuantity > 1) {
            BigDecimal expectedTotalPrice = itemPrice.multiply(BigDecimal.valueOf(itemQuantity));
            Assert.assertEquals(expectedTotalPrice, totalPrice);
        }
        return this;
    }


    @Step("Reduce price by clicking minus button")
    public AddInCartPageSteps MinusBtn() {
        minusBtn.click();

        return this;
    }

    /**
     * შეამცირეთ რაოდენობა და ფასი.
     *
     * ეს მეთოდი ამცირებს ნივთის ფასს მისი რაოდენობის მიხედვით და ამოწმებს ნაჩვენები მთლიან ფასს.
     * თუ რაოდენობა 1-ის ნაკლებია ან ტოლია, ის აკლებს ნივთის ფასს რაოდენობაზე და შემდეგ ამტკიცებს, რომ მოსალოდნელია
     * ჯამური ფასი ემთხვევა რეალურ მთლიან ფასს.
     *
     */
    @Step("Reduce quantity and price")
    public AddInCartPageSteps reduceQuantityPrice() {
        String itemPriceText = itemPrice.getText();
        String itemQuantityValue = itemQuantity.getValue();
        String itemTotalPriceText = itemTotalPrice.getText();
        BigDecimal itemPrice = new BigDecimal(itemPriceText.replaceAll("[^\\d.]", ""));
        int itemQuantity = Integer.parseInt(itemQuantityValue);
        BigDecimal totalPrice = new BigDecimal(itemTotalPriceText.replaceAll("[^\\d.]", ""));
        System.out.println(itemPrice);
        System.out.println(itemQuantity);
        System.out.println(totalPrice);
        if (itemQuantity <= 1) {
            BigDecimal expectedTotalPrice = itemPrice.multiply(BigDecimal.valueOf(itemQuantity));
            Assert.assertEquals(expectedTotalPrice, totalPrice);
        }
        return this;
    }


    @Step("Delete item from cart by clicking X button")
    public AddInCartPageSteps DeleteTimesFromCart() {
        deleteTimesFromCart.click();

        return this;
    }

    @Step("Add Second Item To Cart")
    public AddInCartPageSteps addSecondItemToCart() {
        searchBtn.click();
        inputSearch.setValue("კალამი ბურთულიანი");
        iSearchBtn.click();
        addCartBtn.click();
        addCartPopUp.shouldBe(visible, Duration.ofMillis(5000));
        addSecondItem.click();
        addCartPopUp.shouldBe(visible, Duration.ofMillis(5000));
        insideCart.click();

        return this;
    }

    @Step("Delete all items from cart button")
    public AddInCartPageSteps DeleteAllItemsFromCartBtn() {
        deleteAllItemsFromCartBtn.click();

        return this;
    }

    @Step("Cart is empty")
    public AddInCartPageSteps CartIsEmptyText() {
        cartIsEmptyText.shouldBe(visible);

        return this;
    }

    @Step("Cart Continue Button")
    public AddInCartPageSteps CartContinueButton() {
        cartContinueButton.shouldNotBe(visible,Duration.ofMillis(5000));

        return this;
    }

    @Step("Delete all items from cart button")
    public AddInCartPageSteps DeleteAllItemsCartBtn() {
        deleteAllItemsFromCartBtn.shouldNotBe(visible);

        return this;
    }

    @Step("Click CartContinueBtn")
    public AddInCartPageSteps CartContinueBtn() {
        cartContinueButton.click();

        return this;
    }


    public boolean isCartContinueBtnDisplayed() {
        return false;
    }




}

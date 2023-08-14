package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FormInputPageObject {

    // fillUp forms
    public SelenideElement legalForm1 = $("#pis");
    public SelenideElement personalForm2 = $("#iur");
    public SelenideElement inputCompanyName = $(byAttribute("placeholder","კომპანიის სახელწოდება"));
    public SelenideElement submitBtn = $("#btn2");
    public SelenideElement identifyCode = $(byAttribute("placeholder","საიდენტიფიკაციო კოდი"));
    public SelenideElement addressInput = $(byAttribute("placeholder","ფაქტიური მისამართი"));
    public SelenideElement contactNumber = $(byAttribute("placeholder","საკონტაქტო ნომერი"));
    public SelenideElement getOrder = $(byAttribute("placeholder","როდის გსურთ შეკვეთის მიღება?"));
    public SelenideElement emailInput = $(byAttribute("placeholder","ელ.ფოსტა"));

















}

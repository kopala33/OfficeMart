package DataObject;

public interface FormInput {

    String compName = "kopala";
    String codeIn = "data"; // negative
    String codeInput = "12345678910"; // negative
    String codeInputField = "123456789101112"; // negative
    String codeInField = "1234567891011"; // positive
    String addressValue = "Tbilisi"; // positive
    String contactValue = "phoneNumber"; // negative
    String contactInputValue = "55555555"; // negative
    String contactIncorrectValue = "555533338888"; // negative
    String contactCorrectValue = "555533338"; // positive
    String getOrderValue = "3388"; // negative
    String getOrderIn = "338899"; // positive
    String getEmailIn = "test@gmail.com"; // positive
    String IncorrectEmail = "test.gmail.com"; // negative
    String InvalidEmailIn = "test@gmail"; // negative
    String InvalidEmail = "test.gmail@"; // negative




}

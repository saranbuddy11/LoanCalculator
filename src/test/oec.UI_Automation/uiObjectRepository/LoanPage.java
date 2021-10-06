package uiObjectRepository;

import base.FunctionalLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LoanPage extends FunctionalLibrary {

    private static final String APPLICATION_TYPE_XPATH = "//label[@for='application_type_single']";
    private static final String DEPENDANTS_XPATH = "//select[@title='Number of dependants']";
    private static final String INCOME_XPATH = "//input[@aria-labelledby='q2q1']";
    private static final String OTHER_INCOME_XPATH = "//input[@aria-labelledby='q2q2']";
    private static final String EXPENSES_XPATH = "//input[@aria-labelledby='q3q1']";
    private static final String HOME_LOAN_REPAYMENT_XPATH = "//input[@aria-labelledby='q3q2']";
    private static final String LOAN_REPAYMENT_XPATH = "//input[@aria-labelledby='q3q3']";
    private static final String COMMITMENTS_XPATH = "//input[@aria-labelledby='q3q4']";
    private static final String CREDIT_CARD_XPATH = "//input[@aria-labelledby='q3q5']";

    @FindBy(xpath = APPLICATION_TYPE_XPATH)
    private WebElement applicationType;
    @FindBy(xpath = DEPENDANTS_XPATH)
    private WebElement dependants;
    @FindBy(id = "borrow_type_home")
    private WebElement borrowType;
    @FindBy(xpath = INCOME_XPATH)
    private WebElement inputIncome;
    @FindBy(xpath = OTHER_INCOME_XPATH)
    private WebElement inputOtherIncome;
    @FindBy(xpath = EXPENSES_XPATH)
    private WebElement inputExpenses;
    @FindBy(xpath = HOME_LOAN_REPAYMENT_XPATH)
    private WebElement inputHomeLoanRepay;
    @FindBy(xpath = LOAN_REPAYMENT_XPATH)
    private WebElement inputLoanRepay;
    @FindBy(xpath = COMMITMENTS_XPATH)
    private WebElement inputCommitment;
    @FindBy(xpath = CREDIT_CARD_XPATH)
    private WebElement inputCredit;
    @FindBy(id = "btnBorrowCalculater")
    private WebElement borrowButton;
    @FindBy(id = "borrowResultTextAmount")
    private WebElement borrowResult;
    @FindBy(className = "start-over")
    private WebElement startOver;
    @FindBy(className = "borrow__error__text")
    private WebElement errorMessage;

    public LoanPage(WebDriver driver) {
        super(driver);
    }

    public LoanPage clickAppType() {
        applicationType.click();
        return this;
    }

    public LoanPage selectDependants() {
        Select s = new Select(dependants);
        s.selectByIndex(0);
        return this;
    }

    public LoanPage selectBorrowType() {
        borrowType.click();
        return this;
    }

    public LoanPage enterIncome(int income) {
        inputIncome.clear();
        inputIncome.sendKeys(String.valueOf(income));
        return this;
    }

    public LoanPage enterOtherIncome(int otherIncome) {
        inputOtherIncome.clear();
        inputOtherIncome.sendKeys(String.valueOf(otherIncome));
        return this;
    }

    public LoanPage enterLivingExpenses(int exp) {
        inputExpenses.clear();
        inputExpenses.sendKeys(String.valueOf(exp));
        return this;
    }

    public LoanPage enterHomeLoanRepayment(int repay) {
        inputHomeLoanRepay.clear();
        inputHomeLoanRepay.sendKeys(String.valueOf(repay));
        return this;
    }

    public LoanPage enterLoanRepayment(int repayLoan) {
        inputLoanRepay.clear();
        inputLoanRepay.sendKeys(String.valueOf(repayLoan));
        return this;
    }

    public LoanPage enterCommitment(int commit) {
        inputCommitment.clear();
        inputCommitment.sendKeys(String.valueOf(commit));
        return this;
    }

    public LoanPage enterCredit(int credit) {
        inputCredit.clear();
        inputCredit.sendKeys(String.valueOf(credit));
        return this;
    }

    public LoanPage clickBorrowButton() {
        scrollIntoView(borrowButton);
        waitInSec(2);
        borrowButton.click();
        return this;
    }

    public String getBorrowResultAmount() {
        borrowResult.isDisplayed();
        waitInSec(2);
        String amount = borrowResult.getText();
        return amount;
    }

    public LoanPage clickStartOverButton() {
        startOver.click();
        return this;
    }

    public String getBorrowButtonStatus() {
        borrowButton.isDisplayed();
        String status = borrowButton.getText();
        return status;
    }

    public String getErrorText() {
        errorMessage.isDisplayed();
        String errorText = errorMessage.getText();
        return errorText;
    }

}
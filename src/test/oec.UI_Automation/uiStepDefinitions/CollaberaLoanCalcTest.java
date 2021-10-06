package uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefinitions.AbstractTest;
import uiAssertion.LoanPageAssertion;

public class CollaberaLoanCalcTest extends AbstractTest {
    @Given("Go to the URL")
    public void go_to_the_URL() {
        super.setUp();
        loanPage.startAssertions(LoanPageAssertion.class)
                .assertAtLoginPage()
                .endAssertion();
    }

    @When("Click Single in Application Type")
    public void clickSingleInApplicationType() {
        loanPage.clickAppType();
    }

    @And("Choose zero dependants from drop down")
    public void chooseZeroDependantsFromDropDown() {
        loanPage.selectDependants();
    }

    @And("Click on home to live in tab")
    public void clickOnHomeToLiveInTab() {
        loanPage.selectBorrowType();
    }

    @And("Enter Income {int} dollar")
    public void enterIncomeDollar(int income) {
        loanPage.enterIncome(income);

    }

    @And("Enter other income {int} dollar")
    public void enterOtherIncomeDollar(int otherIncome) {
        loanPage.enterOtherIncome(otherIncome);
    }

    @And("Enter living expenses {int} dollar")
    public void enterLivingExpensesDollar(int exp) {
        loanPage.enterLivingExpenses(exp);
    }

    @And("Enter current home loan repayments {int} dollar")
    public void enterCurrentHomeLoanRepaymentsDollar(int repay) {
        loanPage.enterHomeLoanRepayment(repay);
    }

    @And("Enter other loan repayments {int} dollar")
    public void enterOtherLoanRepaymentsDollar(int repayLoan) {
        loanPage.enterLoanRepayment(repayLoan);
    }

    @And("Enter other commitments {int} dollar")
    public void enterOtherCommitmentsDollar(int commit) {
        loanPage.enterCommitment(commit);
    }

    @And("Enter total credit card limits {int} dollar")
    public void enterTotalCreditCardLimitsDollar(int credit) {
        loanPage.enterCredit(credit);
    }

    @Then("Verify that Estimate Borrow is {string} dollar")
    public void verifyThatEstimateBorrowIsDollar(String estimate) {
        loanPage.clickBorrowButton().startAssertions(LoanPageAssertion.class)
                .assertBorrowingEstimateIsDisplayed(estimate)
                .endAssertion();
    }

    @And("Click on StartOver Button and verify the form is cleared")
    public void clickOnStartOverButtonAndVerifyTheFormIsCleared() {
        loanPage.clickStartOverButton().startAssertions(LoanPageAssertion.class)
                .assertFormCleared()
                .endAssertion();

    }

    @When("Entering only {int} dollar for Living expenses, and leaving all other fields as zero")
    public void enteringOnlyDollarForLivingExpensesAndLeavingAllOtherFieldsAsZero(int livingExpense) {
        loanPage.enterLivingExpenses(livingExpense);
    }

    @And("Click ‘Work out how much I could borrow’")
    public void clickWorkOutHowMuchICouldBorrow() {
        loanPage.clickBorrowButton();
    }

    @Then("Verify returns message {string}")
    public void verifyReturnsMessage(String errorMessage) {
        loanPage.startAssertions(LoanPageAssertion.class)
                .assertStatusMessage(errorMessage)
                .endAssertion();
    }
}

package uiAssertion;


import base.AbstractAssertion;
import uiObjectRepository.LoanPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoanPageAssertion extends AbstractAssertion<LoanPage> {

    public LoanPageAssertion assertAtLoginPage() {
        String currentUrl = functionalLibrary.getPageUrl();
        String expectedUrl = functionalLibrary.getBaseURL();
        assertThat(functionalLibrary.isAt(expectedUrl)).as("verify if at 'Home Loan' page" +
                "\nExpected: " + expectedUrl + "\nActual: " + currentUrl)
                .isTrue();
        return this;
    }

    public LoanPageAssertion assertBorrowingEstimateIsDisplayed(String expectedEstimate) {
        String actualValue = functionalLibrary.getBorrowResultAmount();
        assertThat(actualValue).as("verify that Borrowing Estimate is displayed in Loan Page is" +
                "\nExpected: " + expectedEstimate + "\nActual: " + actualValue).isEqualTo(expectedEstimate);
        return this;
    }

    public LoanPageAssertion assertFormCleared() {
        String actualStatus = functionalLibrary.getBorrowButtonStatus();
        String expectedStatus = "Work out how much I could borrow";
        assertThat(actualStatus).as("verify that Borrow Button Calculator is displayed in Loan Page is" +
                "\nExpected: " + expectedStatus + "\nActual: " + actualStatus).isEqualTo(expectedStatus);
        return this;
    }

    public LoanPageAssertion assertStatusMessage(String expectedErrorText) {
        String actualErrorText = functionalLibrary.getErrorText();
        assertThat(actualErrorText).as("verify that Error Message is displayed in Loan Page is" +
                "\nExpected: " + expectedErrorText + "\nActual: " + actualErrorText).isEqualTo(expectedErrorText);
        return this;
    }

}
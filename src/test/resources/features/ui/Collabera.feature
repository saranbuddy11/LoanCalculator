@Smoke
Feature: Loan Calculator Smoke Test

  Scenario: LoanCalculatorTest
    Given Go to the URL
    When Click Single in Application Type
    And Choose zero dependants from drop down
  	And Click on home to live in tab
  	And Enter Income 80000 dollar
  	And Enter other income 10000 dollar
    And Enter living expenses 500 dollar
    And Enter current home loan repayments 0 dollar
    And Enter other loan repayments 100 dollar
    And Enter other commitments 0 dollar
    And Enter total credit card limits 10000 dollar
    Then Verify that Estimate Borrow is "$508,000" dollar
    And Click on StartOver Button and verify the form is cleared
    When Entering only 1 dollar for Living expenses, and leaving all other fields as zero
    And Click ‘Work out how much I could borrow’
    Then Verify returns message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."

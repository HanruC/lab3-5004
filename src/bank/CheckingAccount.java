package bank;

/**
 * This is checking account class.
 */
public class CheckingAccount extends accounts {
  
  /**
   * This is a constructor for checking account.
   * Also, checking if the starter is lower than 100 to take the penalty.
   * @param starter starter money in account.
   */
  public CheckingAccount(double starter) {
    super(starter);
    helperPenaltyBoundary();
  }
  
  @Override
  public boolean withdraw(double amount) {
    int withdrawMin = 0;
    if (amount < withdrawMin) {
      return false;
    }
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    int penaltyBoundary = 100;
    if (this.balance < penaltyBoundary) {
      this.penaltyCharged = true;
    }
    return true;
  }
  
  /**
   * Method of maintenance.
   * Check if the penalty charge should be applied.
   * Also, taking the logic that after taking penalty, if the balance is still below 100.
   * If no deposit action apply, the penalty will still be on.
   */
  @Override
  public void performMonthlyMaintenance() {
    if (this.penaltyCharged) {
      this.balance -= 5;
    }
    helperPenaltyBoundary();
  }
}

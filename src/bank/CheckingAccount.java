package bank;

/**
 * This is a public class of CheckingAccount and implements IAccount interface.
 */
public class CheckingAccount implements IAccount {
  private double balance;
  private boolean penaltyCharged; //keep tracking only once penalty charged a month.
  
  /**
   * Helper function for penalty in order to prevent redundant.
   */
  private void helperPenaltyBoundary() {
    int penaltyBoundary = 100;
    if (this.balance < penaltyBoundary) {
      this.penaltyCharged = true;
    } else {
      this.penaltyCharged = false; //set to false be default means not charged.
    }
  }
  
  /**
   * This is a constructor for checking account.
   * Also, checking if the starter is lower than 100 to take the penalty.
   * @param starter starter money in account.
   */
  public CheckingAccount(double starter) {
    double minStarter = 0.01;
    if (starter < minStarter) {
      throw new IllegalArgumentException("Starter amount for checking should be larger than 0.01");
    }
    this.balance = starter;
    helperPenaltyBoundary();
  }
  
  /**
   * Method of deposit.
   * Checking deposit amount.
   * @param amount amount to deposit.
   */
  @Override
  public void deposit(double amount) {
    int minAmount = 0;
    if (amount < minAmount) {
      throw new IllegalArgumentException("Deposit amount should be larger than 0.");
    }
    this.balance += amount;
  }
  
  /**
   * Method of withdraw.
   * Checking if balance after withdraw is lower than 100.
   * Check if withdraw amount is larger than current balance.
   * @param amount amount to withdraw.
   * @return true or false.
   */
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
   * Method to get current balance.
   * @return balance
   */
  @Override
  public double getBalance() {
    return this.balance;
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
  
  /**
   * Override toString method.
   * @return string of balance.
   */
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

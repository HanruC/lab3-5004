package bank;

/**
 * This is an abstract class accounts for preventing redundant.
 */
public abstract class accounts implements IAccount {
  protected double balance;
  protected boolean penaltyCharged;
  
  /**
   * Constructor for both checking and saving.
   * @param starter money amount.
   */
  public accounts(double starter) {
    double minStarter = 0.01;
    if (starter < minStarter) {
      throw new IllegalArgumentException("Starter amount for checking should be larger than 0.01");
    }
    this.balance = starter;
  }
  
  /**
   * Helper function for penalty in order to prevent redundant.
   */
  protected void helperPenaltyBoundary() {
    int penaltyBoundary = 100;
    if (this.balance < penaltyBoundary) {
      this.penaltyCharged = true;
    } else {
      this.penaltyCharged = false; //set to false be default means not charged.
    }
  }
  
  /**
   * Method of deposit.
   * Checking deposit amount.
   *
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
   * Abstract class.
   */

  @Override
  public abstract boolean withdraw(double amount);
  
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
   * Only in abstract mode because both used in checking and saving but different usage.
   */
  @Override
  public abstract void performMonthlyMaintenance();
  
  /**
   * Override toString method.
   * @return string of balance.
   */
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

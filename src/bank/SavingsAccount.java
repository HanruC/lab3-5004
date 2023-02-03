package bank;

/**
 * This is a public class called SavingsAccount which also implements IAccount interface.
 */
public class SavingsAccount implements IAccount {
  private double balance;
  private int withdrawTimes; // keep track penalty free withdraw
  
  /**
   * This is a default constructor for SavingsAccount.
   * In constructor, we also need to check if the starter is larger than 100.
   * @param starter starter amount of money.
   */
  public SavingsAccount(double starter) {
    double lowestStarter = 0.01;
    if (starter < lowestStarter) {
      throw new IllegalArgumentException("You should have more than 0.01 in starter amount.");
    }
    this.balance = starter; //default constructor.
    this.withdrawTimes = 0;
  }
  
  /**
   * This is a deposit method for adding deposit into the account.
   * @param amount amount of deposit.
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
   * This is a method for withdraw.
   * Also, in this method, we need to check if the balance and amount relationships.
   * @param amount amount to withdraw.
   * @return true or false
   */
  @Override
  public boolean withdraw(double amount) {
    int lowerBoundary = 0;
    if (amount < lowerBoundary) {
      return false;
    }
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    this.withdrawTimes++;
    return true;
  }
  
  /**
   * This is a method to get balance of the account.
   * @return balance
   */
  @Override
  public double getBalance() {
    return this.balance;
  }
  
  /**
   * This is a method for behaving maintenance.
   * In this method, we need to check if withdraw times are larger than 6.
   * Then, after checking, reset the withdrawal times to 0.
   */
  @Override
  public void performMonthlyMaintenance() {
    int withDrawLimit = 6;
    if (withdrawTimes > withDrawLimit) {
      this.balance -= 14;
    }
    this.withdrawTimes = 0; //end of the month, reset withdraw time to 0.
  }
  
  /**
   * This is a toString method to print out the balance.
   * @return string of balance.
   */
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

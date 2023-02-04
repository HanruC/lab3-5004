package bank;

/**
 * This is a public class called SavingsAccount which also implements IAccount interface.
 * And also extends abstract class accounts.
 */
public class SavingsAccount extends accounts {
  private int withdrawTimes;
  
  /**
   * This is a default constructor for SavingsAccount.
   * In constructor, we also need to check if the starter is larger than 100.
   * @param starter starter amount of money.
   */
  public SavingsAccount(double starter) {
    super(starter);
    this.withdrawTimes = 0;
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
}

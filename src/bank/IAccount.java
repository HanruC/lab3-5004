package bank;

/**
 * This is an interface for SavingsAccount and CheckingAccount classes
 * Below methods are all shared in these two classes.
 */
public interface IAccount {
  
  /**
   * Deposit method that shares with two classes.
   * @param amount amount to deposit.
   */
  void deposit(double amount);
  
  /**
   * Withdraw method that gives true or false if withdraw successfully.
   * @param amount amount to withdraw.
   * @return true or false.
   */
  boolean withdraw(double amount);
  
  /**
   * Method of getting balance.
   * @return balance.
   */
  double getBalance();
  
  /**
   * Method of performing Monthly Maintenance.
   * Charging penalty if necessary.
   */
  void performMonthlyMaintenance();
}

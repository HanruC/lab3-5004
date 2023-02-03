package bank;

/**
 * This is an interface for SavingsAccount and CheckingAccount classes
 * Below methods are all shared in these two classes.
 */
public interface IAccount {
  void deposit(double amount);
  
  boolean withdraw(double amount);
  
  double getBalance();
  
  void performMonthlyMaintenance();
}

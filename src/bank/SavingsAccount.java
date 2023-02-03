package bank;

public class SavingsAccount implements IAccount {
  private double balance;
  private int withdrawTimes; // keep track penalty free withdraw
  
  public SavingsAccount(double starter) {
    if (starter < 0.01) {
      throw new IllegalArgumentException("You should have more than 0.01 in starter amount.");
    }
    this.balance = starter; //default constructor.
    this.withdrawTimes = 0;
  }
  @Override
  public void deposit(double amount) {
    int minAmount = 0;
    if(amount < minAmount) {
      throw new IllegalArgumentException("Deposit amount should be larger than 0.");
    }
    this.balance += amount;
  }
  
  @Override
  public boolean withdraw(double amount) {
    if (amount < 0) {
      return false;
    }
    if (this.balance - amount >= 0) {
      if (this.withdrawTimes > 6) {
        this.balance -= 14; //penalty over 6 times withdraw;
      }
      this.balance -= amount;
      this.withdrawTimes++;
      return true;
    }
    return false;
  }
  
  @Override
  public double getBalance() {
    return this.balance;
  }
  
  @Override
  public void performMonthlyMaintenance() {
    this.withdrawTimes = 0; //end of the month, reset withdraw time to 0.
  }
  
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

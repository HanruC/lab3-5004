package bank;

public class CheckingAccount implements IAccount {
  private double balance;
  //private boolean penaltyCharged; keep tracking only once penalty charged a month.
  
  public CheckingAccount(double starter) {
    double minStarter = 0.01;
    if (starter < minStarter) {
      throw new IllegalArgumentException("Starter amount for checking should be larger than 0.01");
    }
    this.balance = starter;
    //this.penaltyCharged = false; set to false be default means not charged.
  }
  @Override
  public void deposit(double amount) {
    int minAmount = 0;
    if (amount < minAmount) {
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
      this.balance -= amount;
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
    if (this.balance < 100) {
      this.balance -= 5;
    }
  }
}

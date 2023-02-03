package bank;


public class CheckingAccount implements IAccount {
  private double balance;
  private boolean penaltyCharged; //keep tracking only once penalty charged a month.
  
  public CheckingAccount(double starter) {
    double minStarter = 0.01;
    if (starter < minStarter) {
      throw new IllegalArgumentException("Starter amount for checking should be larger than 0.01");
    }
    this.balance = starter;
    if (this.balance < 100) {
      this.penaltyCharged = true;
    } else {
      this.penaltyCharged = false; //set to false be default means not charged.
    }
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
  
  @Override
  public double getBalance() {
    return this.balance;
  }
  
  @Override
  public void performMonthlyMaintenance() {
    if (this.penaltyCharged) {
      this.balance -= 5;
    }
    if (this.balance < 100) {
      this.penaltyCharged = true;
    } else {
      this.penaltyCharged = false;
    }
  }
  
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

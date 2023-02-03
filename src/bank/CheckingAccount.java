package bank;

import java.text.DecimalFormat;

public class CheckingAccount implements IAccount {
  private double balance;
  private boolean penaltyCharged; //keep tracking only once penalty charged a month.
  
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
    int withdrawMin = 0;
    if (amount < withdrawMin) {
      return false;
    }
    if (this.balance < amount) {
      return false;
    }
    this.balance -= amount;
    int penaltyBalance = 100;
    if (this.balance < penaltyBalance) {
      this.penaltyCharged = true;  // set to true for setting that penalty should be applied.
    }
    return true;
  }
  
  @Override
  public double getBalance() {
    return this.balance;
  }
  
  @Override
  public void performMonthlyMaintenance() {
    if (this.penaltyCharged == true) {
      this.balance -= 5;
      this.penaltyCharged = false;
    }
  }
  
  @Override
  public String toString() {
    return String.format("$%.2f", this.balance);
  }
}

package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * This is a test class for checking account.
 */
public class CheckingAccountTest {
  
  /**
   * Test for constructor to see if meeting all cases.
   */
  @Test
  public void testConstructor() {
    try {
      new CheckingAccount(-0.02);
    } catch (IllegalArgumentException e) {
      assertEquals("Starter amount for checking should be larger than 0.01",
              e.getMessage());
    }
    CheckingAccount account2 = new CheckingAccount(100);
    assertEquals(100, account2.getBalance(), 0.01);
  }
  
  /**
   * This is a test for checking deposit.
   */
  @Test
  public void deposit() {
    try {
      CheckingAccount account3 = new CheckingAccount(300);
      account3.deposit(-5);
    } catch (IllegalArgumentException e) {
      assertEquals("Deposit amount should be larger than 0.", e.getMessage());
    }
    CheckingAccount account4 = new CheckingAccount(1000);
    account4.deposit(100);
    assertEquals(1100, account4.getBalance(), 0.01);
  }
  
  /**
   * This is a method for testing withdrawal.
   */
  @Test
  public void withdraw() {
    CheckingAccount account5 = new CheckingAccount(500);
    assertFalse(account5.withdraw(-5));
    assertFalse(account5.withdraw(600));
    assertTrue(account5.withdraw(420));
  }
  
  /**
   * This is a method for getting balance.
   */
  @Test
  public void getBalance() {
    CheckingAccount account6 = new CheckingAccount(600);
    assertEquals(600, account6.getBalance(), 0.01);
  }
  
  /**
   * This is a method for checking correctness of monthly maintenance.
   */
  @Test
  public void performMonthlyMaintenance() {
    CheckingAccount account = new CheckingAccount(500);
    account.withdraw(420);
    account.performMonthlyMaintenance();
    assertEquals(75, account.getBalance(), 0.01);
    
    CheckingAccount account9 = new CheckingAccount(70);
    account9.performMonthlyMaintenance();
    assertEquals(65, account9.getBalance(), 0.01);
    account9.performMonthlyMaintenance();
    assertEquals(60, account9.getBalance(), 0.01);
  }
  
  /**
   * Test for toString method.
   */
  @Test
  public void testToString() {
    CheckingAccount accountTest = new CheckingAccount(10000);
    assertEquals("$10000.00", accountTest.toString());
  }
}
package bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for saving account.
 */
public class SavingsAccountTest {
  
  /**
   * Test for constructor.
   */
  @Test
  public void testConstructor() {
    try {
      new SavingsAccount(-2);
    } catch (IllegalArgumentException e) {
      assertEquals("You should have more than 0.01 in starter amount.", e.getMessage());
    }
    SavingsAccount account2 = new SavingsAccount(150);
    assertEquals(150, account2.getBalance(), 0.01);
  }
  
  /**
   * Test for deposit. Both error and no error.
   */
  @Test
  public void testDeposit() {
    SavingsAccount account3 = new SavingsAccount(200);
    try {
      account3.deposit(-1);
    } catch (IllegalArgumentException e) {
      assertEquals("Deposit amount should be larger than 0.", e.getMessage());
    }
    account3.deposit(300);
    assertEquals(500, account3.getBalance(),0.01);
  }
  
  /**
   * Test for withdrawal.
   */
  @Test
  public void withdraw() {
    SavingsAccount account4 = new SavingsAccount(300);
    assertTrue(account4.withdraw(50));
    assertFalse(account4.withdraw(400));
    assertFalse(account4.withdraw(-5));
    assertEquals(250, account4.getBalance(), 0.01);
  }
  
  /**
   * This is a test for getting balance of the account.
   */
  @Test
  public void getBalance() {
    SavingsAccount account5 = new SavingsAccount(3000);
    assertEquals(3000, account5.getBalance(), 0.01);
  }
  
  /**
   * This is the test for performing monthly maintenance.
   */
  @Test
  public void performMonthlyMaintenance() {
    SavingsAccount account6 = new SavingsAccount(500);
    for (int i = 0; i < 8; i++) {
      account6.withdraw(20);
    }
    account6.performMonthlyMaintenance();
    assertEquals(326, account6.getBalance(), 0.01);
  }
  
  /**
   * This is a test for method toString.
   */
  @Test
  public void testToString() {
    SavingsAccount account7 = new SavingsAccount(400);
    assertEquals("$400.00", account7.toString());
  }
}
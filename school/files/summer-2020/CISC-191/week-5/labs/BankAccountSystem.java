import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Creates two Threads through Executor.newFixedThreadPool(), each having to
 * execute one specific task: deposit and withdraw.
 *
 * The program will generate random amount (from 0 to MAX_AMOUNT) to deposit and
 * withdraw continuously until the account balance drops exactly to 0.
 *
 * @author Mark Lucernas
 * Date: 2020-07-19
 */
public class BankAccountSystem {
  private static Account account = new Account();
  private static AtomicBoolean isRunning = new AtomicBoolean(true); // Controls the longevity of the program
  private static AtomicLong totalTime = new AtomicLong(); // Holds total accumulated time of the deposit and withdraw method
  private static int MAX_AMOUNT = 10000;

  public static class DepositTask implements Runnable {
    @Override
    public void run() {
      try {
        while (isRunning.get()) { // Keep adding an amount to the account
          account.deposit((int)(Math.random() * MAX_AMOUNT) + 1);
          Thread.sleep(1); // Purposely delay it to let the withdraw method proceed
        }
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  public static class WithdrawTask implements Runnable {
    @Override
    public void run() {
      while (isRunning.get()) { // Keep subtracting an amount from the account
        account.withdraw((int)(Math.random() * MAX_AMOUNT) + 1);
      }
    }
  }

  private static class Account {
    private static Lock lock = new ReentrantLock();
    private static Condition newDeposit = lock.newCondition();

    private int balance = 0;

    public int getBalance() {
      return balance;
    }

    public void withdraw(int amount) {
      lock.lock(); // Acquire the lock
      long start = System.currentTimeMillis();
      try {
        while (balance < amount) {
          newDeposit.await();
        }

        balance -= amount;
        System.out.println("\t\t\tWithdraw $" + amount +
          "\t\t" + "New Balance $" + getBalance());

        if (balance == 0) {
          isRunning.set(false);
          // Print total accumulated time elapsed
          System.out.println("\nTotal time elapsed " + (totalTime.get() / 1000.0) + "s");
        }
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      finally {
        lock.unlock(); // Release the lock
        totalTime.addAndGet(System.currentTimeMillis() - start);
      }
    }

    public void deposit(int amount) {
      lock.lock(); // Acquire the lock
      long start = System.currentTimeMillis();
      try {
        balance += amount;
        System.out.println("Deposit $" + amount +
          "\t\t\t\t\t" + "New Balance $" + getBalance());

        // Signal thread waiting on the condition
        newDeposit.signalAll();
      }
      finally {
        lock.unlock(); // Release the lock
        totalTime.addAndGet(System.currentTimeMillis() - start);
      }
    }
  }

  public static void main(String[] args) {
    // Create a thread pool with two threads
    ExecutorService executor = Executors.newFixedThreadPool(2);

    System.out.println("Thread 1\t\tThread 2\t\tBalance");
    executor.execute(new DepositTask());
    executor.execute(new WithdrawTask());
    executor.shutdown();
  }
}

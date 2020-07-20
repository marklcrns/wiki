import java.util.Scanner;

/**
 * Multi-threading: Basic Thread Synchronization.
 * Ref: https://www.youtube.com/watch?v=_aNO6x8HXZ0
 */
class Processor extends Thread {

  private volatile boolean running = true;

  public void run() {
    int helloCt = 0;
    while (running) {
      helloCt++;
      System.out.println("Hello " + helloCt);

      try {
        Thread.sleep(1000);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void shutdown() {
    running = false;
  }
}

public class App {
  public static void main(String[] args) {
    Processor proc1 = new Processor();
    proc1.start();

    System.out.println("Press return to stop...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();

    proc1.shutdown();
  }
}

/**
 * Multi-threading Example Using Low-Level Synchronization.
 * Ref: https://www.youtube.com/watch?v=wm1O8EE0X8k
 */
public class App {

  public static void main(String[] args) throws InterruptedException {

    final Processor processor = new Processor();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          processor.produce();
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          processor.consume();
        } catch(InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();

  }
}

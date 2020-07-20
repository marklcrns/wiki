/**
 * Multi-threading: Wait and Notify.
 * Ref: https://www.youtube.com/watch?v=gx_YUORX5vk
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

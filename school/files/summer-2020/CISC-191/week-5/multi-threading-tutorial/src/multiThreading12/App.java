import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Multi-threading: Semaphores.
 * Ref: https://www.youtube.com/watch?v=KxTRsvgqoVQ
 */
public class App {

  public static void main(String[] args) throws Exception {
    Connection.getInstance().connect();

    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 0; i < 200; i++) {
      executor.submit(new Runnable() {
        public void run() {
          Connection.getInstance().connect();
        }
      });
    }

    executor.shutdown();

    executor.awaitTermination(1, TimeUnit.DAYS);
  }
}

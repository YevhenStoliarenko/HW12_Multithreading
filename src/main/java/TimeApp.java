
public class TimeApp {
    public  static  void timer() {
        Thread thread1 = new Thread(() -> {
            int counter = 1;
            for (int i = 1; ; i++) {
                System.out.println(counter + " seconds");
                counter++;
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (counter == 5) {
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; ; i++) {
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("5 seconds passed");

            }
        });

        thread1.start();
        thread2.start();

    }

}

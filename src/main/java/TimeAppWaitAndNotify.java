public class TimeAppWaitAndNotify {

    private int second = 1;

    public void timerWithWaitAndNotify() throws InterruptedException {
        TimeAppWaitAndNotify timeAppWait = new TimeAppWaitAndNotify();
        Thread thread1 = new Thread(()-> {
            try {
                timeAppWait.time();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(()-> {
            try {
                timeAppWait.fiveSecond();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }


    public void fiveSecond() throws InterruptedException {
        synchronized (this){
            while (second > 0){
                if (second % 5 == 0){
                    System.out.println( second + " - 5 seconds passed");
                    second++;
                    notifyAll();
                    Thread.sleep(1000L);
                } else {
                    wait();
                }
            }
        }


    }

    public void time() throws InterruptedException {
        synchronized (this){
            while (second > 0){
                if(second % 5 != 0){
                    System.out.println(second + " seconds");
                    second++;
                    notifyAll();
                    Thread.sleep(1000L);
                } else {
                    wait();
                }
            }
        }


    }
}

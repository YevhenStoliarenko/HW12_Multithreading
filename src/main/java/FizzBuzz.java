public class FizzBuzz {

    public void fizzBuzzTest() throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(n);
        Thread thread1 = new Thread(()-> {
            try {
                fizzBuzz.counter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(()-> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread3 = new Thread(()-> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(()-> {
            try {
                fizzBuzz.fizzBuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }

    private int count = 1;
    private int n;

    public FizzBuzz(int n) {
        this.count = count;
        this.n = n;
    }

    public synchronized void counter () throws InterruptedException {
        while (count <= n) {
            Thread.sleep(300L);
            if(count % 3 != 0 && count % 5 != 0){
                System.out.println(count);
                count++;
                notifyAll();
            } else {
                wait();
            }

        }


    }

    public synchronized void fizz () throws InterruptedException {
        while (count <= n){
            if (count % 3 == 0 && count % 5 != 0){
                System.out.println("FIZZ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }


    }

    public synchronized void buzz () throws InterruptedException {
        while (count <= n){
            if (count % 5 == 0 && count % 3 != 0){
                System.out.println("BUZZ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }


    }

    public synchronized void fizzBuzz () throws InterruptedException {
        while (count <= n){
            if (count % 3 == 0 && count % 5 == 0){
                System.out.println("FIZZBUZZ");
                count++;
                notifyAll();
            } else {
                wait();
            }
        }

    }

}

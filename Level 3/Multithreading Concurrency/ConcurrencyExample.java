import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is working");
            counter++;
            System.out.println("Thread " + Thread.currentThread().getId() + " incremented the counter to " + counter);
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        return counter;
    }
}

class WorkerThread implements Runnable {
    private final SharedResource sharedResource;

    public WorkerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sharedResource.increment();
        }
    }
}

public class ConcurrencyExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(new WorkerThread(sharedResource));
        Thread thread2 = new Thread(new WorkerThread(sharedResource));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final counter value: " + sharedResource.getCounter());
    }
}

import java.util.concurrent.Semaphore;

public class JavaSemaphore {
    private static final int MAX_CONCURRENT_THREADS = 2;
    private final Semaphore coolLock = new Semaphore(MAX_CONCURRENT_THREADS, true);
    
    public void startTest() {
        for(int i = 0; i < 10; i++) {
            Person person = new Person();
            person.start();
        }
    }

    public class Person extends Thread {
        @Override
        public void run() {
            try {
                coolLock.acquire();               
            } catch (InterruptedException e) {
                System.out.println("Recieved InterruptedException");
                return;
            }
            System.out.println("Thread" + this.getId() + " starts using the resource - Acquire()");
            try {
                sleep(1000);
            } catch (Exception e) {
            } finally {
                coolLock.release();
            }
            System.out.println("Thread " + this.getId() + " stopped using the resource - Release");
            
        }
    }
    
    public static void main(String args[]) {
        JavaSemaphore test = new JavaSemaphore();
        test.startTest();
    }
}

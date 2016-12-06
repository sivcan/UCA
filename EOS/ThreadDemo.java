class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    
    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating a thread : " + threadName);
    }
    
    public void joiner() {
         try {
                t.join(); 
                System.out.println("Join Called, Waiting Done. Thread 2 starting now...!");
        } catch (InterruptedException e) {
            System.out.println("Exception raised. Cannot wait!");
        }
    }
    
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread : " + threadName + ", Time remaining : " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " exiting.");  
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if(t == null) {
            t = new Thread(this, threadName);
            t.start();    
        } 
    }
}

public class ThreadDemo {
    public static void main(String args[]) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();
        R1.joiner(); 
        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();
    }
}

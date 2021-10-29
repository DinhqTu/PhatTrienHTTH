package cnTuan3;

public class Tuan3bai1 implements Runnable {
    private String message ; 
    public Tuan3bai1 {
        this.message = s; 
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "(Star) message = " + message);
        processMessage (); 
        System.out.println(Thread.currentThread().getName()+"End");
    }
    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public class TestThreadPool {
        public static void main(String[] args) {
            // tạo một pool chứa 5 threads
            ExecutorService executor = Executors.newFixedThreadPool(5);
            for (int i = 0; i < 10; i++) {
                Runnable worker = new WorkerThread("" + i);
                // call phương thức execute của ExecutorService
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
     
            System.out.println("Finished all threads");
        }
    }
}

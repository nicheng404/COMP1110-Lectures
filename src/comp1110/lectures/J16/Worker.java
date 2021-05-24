package comp1110.lectures.J16;

public class Worker implements Runnable {

    public static final int NUM_THREADS = 4;
    static final int WORK_ITEMS = 1000;

    private int nextWorkItem = 0;

    private void pretendToWork(int workItem) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Increment the value of the nextWorkItem field.
     * Note: this method is synchronized to ensure only one thread at a time
     * can execute the method.
     * @return the value of the nextWorkItem field before it was incremented
     */
    private synchronized int getNextWorkItem() {
        int n = nextWorkItem;
        nextWorkItem = n + 1;
        return n;
    }

    @Override
    public void run() {
        int completed = 0;
        int workItem;
        while ((workItem = getNextWorkItem()) < WORK_ITEMS) {
            pretendToWork(workItem);
            completed++;
        }
        System.out.println(Thread.currentThread().getName() + " completed " + completed + " work items!");
    }

    public static void main(String[] args) {
        System.out.println("Starting four threads...");
        Worker worker = new Worker();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(worker, "Worker " + i);
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All done!");
    }

}

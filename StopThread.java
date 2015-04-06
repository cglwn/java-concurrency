public class StopThread {
    private static boolean stopRequested;
    
    private static synchronized void requestStop() {
	stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
	return stopRequested;
    }

    public static void main(String[] args)
	throws InterruptedException {
	Thread backgroundThread = new Thread(new Runnable() {
		public void run() {
		    int i = 0;
		    while(!stopRequested)
			System.out.println(i++);
		}
	    });
	backgroundThread.start();

	Thread.sleep(1);
	stopRequested = true;
    }
}
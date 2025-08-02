public class MyThread extends Thread {
	public void run() {
		System.out.println("Thread is running...");

		try {
			// Sleep to simulate timed waiting
			System.out.println("2000ms waiting thread initiated...");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			System.out.println("Thread was interrupted.");
		}

		System.out.println("Thread finished.");
	}

	public static void main(String[] args) {
		MyThread t = new MyThread(); // NEW state

		System.out.println("Thread state after creation: " + t.getState());

		t.start(); // RUNNABLE state
		System.out.println("Thread state after calling start(): " + t.getState());

		try {
			System.out.println("500ms waiting thread initiated...");
			Thread.sleep(500); // Pause main to let t enter TIMED_WAITING
			System.out.println("Thread state while sleeping: " + t.getState());

			t.join(); // Waits for t to finish the 2000 ms thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread state after completion: " + t.getState()); // TERMINATED
	}
}

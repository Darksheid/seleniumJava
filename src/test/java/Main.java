class Counter {
	private int count = 0;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				System.out.println("t1:increment:" + counter.getCount());
				counter.increment();
			}
		});

		Thread t2 = new Thread(() -> {
			// System.out.println("Thread1 running..");
			for (int i = 0; i < 1000; i++) {
				// System.out.println("t2:increment:" + counter.getCount());
				counter.increment();
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count is: " + counter.getCount()); // should be 2000
	}
}

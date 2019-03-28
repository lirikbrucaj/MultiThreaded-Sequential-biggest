public class Shared {
	public static int x;

	public Shared() {
		x = 0;
	}

	// Define a public method named: set. This method should keep the largest
	// integer of all the segments in the above instant variable: x. No two
	// threads should change the content of: x at the same time.
	public synchronized void set(int largest) {
		leave();
		x = largest;

	}

	public synchronized int get() {

		return x;
	}

	// Call this method just before changing the value of x to be sure your
	// program always outputs the correct answer.*/
	private void leave() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

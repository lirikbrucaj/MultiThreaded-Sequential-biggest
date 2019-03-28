
public class MyThread extends Thread {
	private int[] a;
	private int from, to;
	Shared s;

	public MyThread(int[] a, int from, int to, Shared s) {
		this.a = a;
		this.from = from;
		this.to = to;
		this.s = s;
	}

	public void run() {
		// This method should find the largest integer in the segment of array:
		// a
		// of a thread. The last instruction of this method is: s.set(largest).
		// The
		// variable: largest contains the largest integer of the segment.
		synchronized (s) {
			int largest = a[0];
			for (int i = 0; i < a.length; i++)
				if (largest < a[i])
					largest = a[i];
			s.set(largest);

		}
	}
}
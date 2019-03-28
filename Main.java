
import java.util.Random;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Random r = new Random(System.currentTimeMillis());
		int numberOfThreads = r.nextInt(16) + 5; // An integer in the range 5-20
		int n = r.nextInt(501) + 40; // An integer in the range 40-540
		while (n % numberOfThreads != 0)
			n++; // To make n divisible by number of threads
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = r.nextInt(1000); // Filling the array: a with random integers
		sequentialBiggest(a); // Finding the largest without using threads
		MyThread[] list = new MyThread[numberOfThreads];
		Shared s = new Shared();
		int segment = n / numberOfThreads;
		for (int j = 0; j < list.length; j += segment) {
			int from = j;
			int to = j + segment - 1;
			list[j] = new MyThread(a, from, to, s);
		}
		for (int i = 0; i < list.length; i += segment) {
			list[i].start();
		}
		for (int q = 0; q < list.length; q += segment) {
			list[q].join();
		}
		System.out.println("With using threads, largest = " + s.get());
	}

	private static void sequentialBiggest(int[] a) {
		// This method is complete. Do not change it.
		int largest = a[0];
		for (int i = 0; i < a.length; i++)
			if (largest < a[i])
				largest = a[i];
		System.out.println("With no threads, largest = " + largest);
	}
}

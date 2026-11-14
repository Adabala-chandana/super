package day10;

import java.util.Arrays;

public class CountingBits {
	public int[] countBits(int n) {
		int[] output = new int[n + 1];
		int count = 0;
		for (int i = 0; i <=n; i++) {
			count = output[i/2]+ (i % 2);
			output[i] = count;
		}
		return output;
	}
	
	public static void main(String[] args) {
		CountingBits sol = new CountingBits();

	    int n = 5;
	    int[] result = sol.countBits(n);

	    System.out.println(Arrays.toString(result));
	}
}

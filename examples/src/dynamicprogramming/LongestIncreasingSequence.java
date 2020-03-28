package dynamicprogramming;

public class LongestIncreasingSequence {
	
	int[] in;
	
	public LongestIncreasingSequence(int[] in) {
		this.in = in;
	}
	
	public int solve() {
		int[] saved = new int[in.length];
		for (int i = 0; i < in.length; i++) {
			saved[i] = 1;
			for (int j = 0; j < i; j++) {
				if (saved[i] < saved[j] + 1 && in[i] > in[j]) {
					saved[i] = saved[j] + 1;
				}
			}
		}
		int max = 0;
		for (int k = 0; k < saved.length; k++) {
			if (saved[k] > max) {
				max = saved[k];
			}
		}
		PracticeUtils.printArray(1, saved);
		return max;
	}
	
	public static void main(String[] args) {
		int[] in1 = new int[] {1,2,3};
		LongestIncreasingSequence lis1 = new LongestIncreasingSequence(in1);
		boolean correct = 3 == lis1.solve();
		System.out.println(correct);
		int[] in2 = new int[] {1,2,-1, 1, 2, 3, 4, 5};
		LongestIncreasingSequence lis2 = new LongestIncreasingSequence(in2);
		correct = 6 == lis2.solve();
		System.out.println(correct);		
	}
}

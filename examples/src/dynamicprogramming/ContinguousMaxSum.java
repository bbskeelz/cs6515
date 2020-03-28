package dynamicprogramming;

public class ContinguousMaxSum {
	
	int[] in;
	
	public ContinguousMaxSum(int[] in) {
		this.in = in;
	}
	
	public int solve() {
		int[] saved = new int[in.length];
		int max = in[0];
		saved[0] = in[0];
		for (int i = 1; i < in.length; i++) {
			if ((in[i] + saved[i-1] > 0)){
				saved[i]=Math.max(in[i], in[i] + saved[i-1]);
				max = Math.max(max, saved[i]);
			}else {
				saved[i]=in[i];
			}
		}
		PracticeUtils.printArray(1, saved);
		return max;
	}
	
	public static void main(String[] args) {
		int[] in1 = new int[] {1,2,3};
		ContinguousMaxSum lis1 = new ContinguousMaxSum(in1);
		boolean correct = 6 == lis1.solve();
		System.out.println(correct);
		int[] in2 = new int[] {4,5,-10,10, 5, -1, 4};
		ContinguousMaxSum lis2 = new ContinguousMaxSum(in2);
		correct = 18 == lis2.solve();
		System.out.println(correct);
		int[] in3 = new int[] {3, 4,5,-10,10, 5, -1, 4};
		ContinguousMaxSum lis3 = new ContinguousMaxSum(in3);
		correct = 20 == lis3.solve();
		System.out.println(correct);
		int[] in4 = new int[] {-2,-3, 4,-1,-2, 1, 5, -3};
		ContinguousMaxSum lis4 = new ContinguousMaxSum(in4);
		correct = 7 == lis4.solve();
		System.out.println(correct);		
		
		
	}
}

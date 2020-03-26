package dynamicprogramming;

public class LongestCommonSequence {
	
	char[] in1;
	char[] in2;
	
	public LongestCommonSequence(String in1, String in2) {
		this.in1 = in1.toCharArray();
		this.in2 = in2.toCharArray();
	}
	
	public int solve() {
		int[][] saved = new int[in1.length+1][in2.length+1];
		for (int i = 1; i < saved.length; i++) {
			for (int j = 1; j < saved[i].length; j++) {
				if (in1[i-1] == in2[j-1]) {
					saved[i][j] = saved[i-1][j-1] + 1;
				}else {
					int i_max = saved[i][j - 1];
					int j_max = saved[i - 1][j];
					int ij_max = Math.max(i_max, j_max);
					saved[i][j] = ij_max;
				}
			}
		}
		printArray(saved);
		return saved[in1.length][in2.length];
	}
	
	private void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		LongestCommonSequence lis1 = new LongestCommonSequence("a", "ba");
		boolean correct = 1 == lis1.solve();
		System.out.println(correct);
		LongestCommonSequence lis2 = new LongestCommonSequence("bcdbcda", "abecba");
		correct = 4 == lis2.solve();
		System.out.println(correct);		
	}
	
	
}

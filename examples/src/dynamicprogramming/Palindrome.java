package dynamicprogramming;

public class Palindrome {

	char[] in;

	public Palindrome(String in) {
		this.in = in.toCharArray();
	}

	public int solve() {
		int n = in.length;
		boolean[][] saved = new boolean[in.length][in.length];
		saved[0][0] = true;
		int max = 0;
		int[] maxIndex = new int[]{0,0};
		for (int i = n / 2 - 1 + n % 2; i >= 0; i--){   // 1 : 0, 2: 0, 3 : 1, 4 : 1, 5 : 2
			for (int j = n / 2; j < n; j++){  // 1 : 0, 2: 1, 3 : 1, 4 : 2
				if (i == j){
					saved[i][j] = true;
					continue;
				}
				if (in[i] == in[j]){
					saved[i][j] = saved[i+1][j-1];
					if (j-i > max){
						max = j-i;
						maxIndex[0] = i; maxIndex[1] = j;
					}
				}else{
					saved[i][j] = false;
				}
			}
		}
		for (int i = maxIndex[0]; i < maxIndex[1]+1; i++) {
			System.out.print(in[i]);
		}
		System.out.println();
		return max+1;
	}

	public static void main(String[] args) {
		String in1 = "aa";
		Palindrome lis1 = new Palindrome(in1);
		boolean correct1 = 2 == lis1.solve();
		System.out.println(correct1);

		String in2 = "aba";
		Palindrome lis2 = new Palindrome(in2);
		boolean correct2 = 3 == lis2.solve();
		System.out.println(correct2);

		String in3 = "a";
		Palindrome lis3 = new Palindrome(in3);
		boolean correct3 = 1 == lis3.solve();
		System.out.println(correct3);

		String in4 = "a";
		Palindrome lis4 = new Palindrome(in4);
		boolean correct4 = 1 == lis4.solve();
		System.out.println(correct4);

		String in5 = "forgeeksskeegfor";
		Palindrome lis5 = new Palindrome(in5);
		boolean correct5 = 10 == lis5.solve();
		System.out.println(correct5);
	}
}

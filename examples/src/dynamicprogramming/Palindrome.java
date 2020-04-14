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
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				int l = j; int r = j + i;
				if (r == in.length)
					break;
				if (l == r){
					saved[l][r] = true;
					continue;
				}
				if (r - l == 1) {
					saved[l][r] = in[l] == in[r];
					max = 1;
					maxIndex[0] = l; maxIndex[1] = r;
					continue;
				}
				if (in[l] == in[r]){
					saved[l][r] = saved[l+1][r-1];
					if (r-l > max && saved[l][r]){
						max = r-l;
						maxIndex[0] = l; maxIndex[1] = r;
					}
				}else{
					saved[l][r] = false;
				}
			}
		}
		for (int i = maxIndex[0]; i < maxIndex[1]+1; i++) {
			System.out.print(in[i]);
		}
		System.out.println();
		return max+1;
	}
	
    public String longestPalindrome(String s) {
        char[] in = s.toCharArray();
        int n = in.length;
		boolean[][] saved = new boolean[in.length][in.length];
		saved[0][0] = true;
		int max = 0;
		int[] maxIndex = new int[]{0,0};
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				int l = j; int r = j + i;
				if (r == in.length)
					break;
				if (l == r){
					saved[l][r] = true;
					continue;
				}
                if (r - l == 1) {
					saved[l][r] = in[l] == in[r];
					max = 1;
					maxIndex[0] = l; maxIndex[1] = r;
					continue;
				}
				if (in[l] == in[r]){
					saved[l][r] = saved[l+1][r-1];
					if (r-l == max && saved[l][r]){
						max = r-l;
                        System.out.println(max);
						maxIndex[0] = l; maxIndex[1] = r;
					}
				}else{
					saved[l][r] = false;
				}
			}
		}
        StringBuilder sb = new StringBuilder();
		for (int i = maxIndex[0]; i < maxIndex[1]+1; i++) {
			sb.append(in[i]);
		}
		return sb.toString();
    }

	public static void main(String[] args) {
		String in1 = "babad";
		Palindrome lis1 = new Palindrome(in1);
		boolean correct1 = 3 == lis1.solve();
		System.out.println(lis1.longestPalindrome(in1));
		System.out.println(correct1);

		String in2 = "aba";
		Palindrome lis2 = new Palindrome(in2);
		boolean correct2 = 3 == lis2.solve();
		System.out.println(correct2);

		String in3 = "aaaaaaaafaaaaaaaa";
		Palindrome lis3 = new Palindrome(in3);
		boolean correct3 = 17 == lis3.solve();
		System.out.println(correct3);

		String in4 = "aaaaaaaafghbbbbbkbbbbb";
		Palindrome lis4 = new Palindrome(in4);
		boolean correct4 = 11 == lis4.solve();
		System.out.println(correct4);

		String in5 = "forgeeksskeegfor";
		Palindrome lis5 = new Palindrome(in5);
		boolean correct5 = 10 == lis5.solve();
		System.out.println(correct5);
	}
}

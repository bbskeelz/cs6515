package dynamicprogramming;

public class NumberDecoding {

	public static int numDecodings(String s) {
		char[] in = s.toCharArray();
		int[] in2 = new int[in.length];
		for (int i = 0; i < in2.length; i++) {
			in2[i] = in[i] - '0';
		}
		int n = in.length;
		int[] saved = new int[n];
		if (in2[0] == 0)
			return 0;
		saved[0] = 1;
		boolean add;
		for (int i = 1; i < in2.length; i++) {
			int sum = in2[i-1]*10+in2[i];
			add = (10 <= sum && sum <= 26) && (i+1 == in2.length || in2[i+1] > 0);
			if (!add && in2[i] == 0)
				return 0;
			if (in2[i]== 0)
				add=false;
			if (add) {
				if (i > 1)
					saved[i] = saved[i-1] + saved[i-2];
				else {
					saved[i] = saved[i-1] + 1;
				}
			}else {
				saved[i] = saved[i-1];
			}
		}
		return saved[n-1];
	}

	public static void main(String[] args) {
		System.out.println(NumberDecoding.numDecodings("1010"));
		System.out.println(NumberDecoding.numDecodings("1212"));
		System.out.println(NumberDecoding.numDecodings("0"));
		System.out.println(NumberDecoding.numDecodings("7"));
		System.out.println(NumberDecoding.numDecodings("71"));
		System.out.println(NumberDecoding.numDecodings("12"));
		System.out.println(NumberDecoding.numDecodings("12121"));
		System.out.println(NumberDecoding.numDecodings("121201212"));


	}

}

package dynamicprogramming;

/*
Here is yet another variation on the change-making problem (Exercise 6.17).
Given an unlimited supply of coins of denominations x1, x2, . . . , xn, we wish to make change for
a value v using at most k coins; that is, we wish to find a set of ≤ k coins whose total value is v.
This might not be possible: for instance, if the denominations are 5 and 10 and k = 6, then we
can make change for 55 but not for 65. Give an efficient dynamic-programming algorithm for the
following problem.
Input: x1, . . . , xn; k; v.
Question: Is it possible to make change for v using at most k coins, of denominations
x1, . . . , xn?
*/

public class ChangeMakingLimited {
	int[] in;
    int k;
	int v;

	public ChangeMakingLimited(int[] in, int k, int v) {
		this.in = in;
        this.k = k;
		this.v = v;
	}

	private boolean solve() {
		int[] saved = new int[v+1];
		int n = in.length;
		saved[0] = 0;
        for (int j = 1; j <= v; j++) {
            saved[j] = Integer.MAX_VALUE;
        }
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= v; j++) {
				if (in[i-1] <= j && saved[j-in[i-1]] < Integer.MAX_VALUE) {
					saved[j] = Math.min(saved[j], 1+saved[j-in[i-1]]);
				}
				continue;
			}
		}
		return saved[v] <= k;
	}

	public static void main(String[] args) {
		int[] in1 = new int[] {24,51,100};
		int v1 = 175;
        int k1 = 3;
		System.out.println(new ChangeMakingLimited(in1, k1, v1).solve());
        int[] in2 = new int[] {1,5,10};
		int v2 = 55;
        int k2= 6;
		System.out.println(new ChangeMakingLimited(in2, k2, v2).solve());

	}
}

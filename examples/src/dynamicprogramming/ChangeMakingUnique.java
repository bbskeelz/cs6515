package dynamicprogramming;

public class ChangeMakingUnique {
	int[] in;
	int v;
	
	public ChangeMakingUnique(int[] in, int v) {
		this.in = in;
		this.v = v;
	}
	
	private boolean solve() {
		int n = in.length;
		boolean[][] saved = new boolean[n+1][v+1];
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= v; i++) {
				if (in[j-1] == i) {
					saved[j][i] = true;
				}else if (in[j-1] > i) {
					saved[j][i] = saved[j-1][i];
				}else {
					saved[j][i] = saved[j-1][i-in[j-1]];
				}
			}
		}
		return saved[n][v];
	}
	
	public static void main(String[] args) {
		int[] in1 = new int[] {24,51,100};
		int v1 = 175;
		System.out.println(new ChangeMakingUnique(in1, v1).solve());
		int[] in2 = new int[] {1,5,10,25};
		int v2 = 20;
		System.out.println(new ChangeMakingUnique(in2, v2).solve());
		int[] in3 = new int[] {1,5,10,25};
		int v3 = 41;
		System.out.println(new ChangeMakingUnique(in3, v3).solve());

	}
}

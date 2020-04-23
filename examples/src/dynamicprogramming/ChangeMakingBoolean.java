package dynamicprogramming;

public class ChangeMakingBoolean {
	int[] in;
	int v;
	
	public ChangeMakingBoolean(int[] in, int v) {
		this.in = in;
		this.v = v;
	}
	
	private boolean solve() {
		boolean[] saved = new boolean[v+1];
		int n = in.length;
		saved[0] = true;
		for (int i = 0; i <= v; i++) {
			for (int j = 0; j < n; j++) {
				if (in[j] <= i && saved[i-in[j]] == true) {
					saved[i] = true;
				}
				continue;	
			}
		}
		return saved[v];
	}
	
	public static void main(String[] args) {
		int[] in1 = new int[] {24,51,100};
		int v1 = 175;
		System.out.println(new ChangeMakingBoolean(in1, v1).solve());
	}
}

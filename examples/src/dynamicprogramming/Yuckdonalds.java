package dynamicprogramming;

import java.util.Arrays;

public class Yuckdonalds {
	/**
	 * @author sean
	 * @apiNote this is a dynamic programming problem. 
	 * 
	 */
	
	int[] m;
	int[] p;
	int k;
	
	public Yuckdonalds(int[] m, int[] p, int k) {
		this.m = m;
		this.p = p;
		this.k = k;
	}
	
	public int solve() {
		int n = m.length;
		int[] path = new int[n];
		Arrays.fill(path, -1);
		int[] built = new int[n]; /* value of max P if built on Mi */
		built[0] = p[0];
		int max = 0;
		for (int j = 1; j < n; j++) {
				/* subproblem :  determine built[j] and skipped[j]
				/* edge */
				int i = j-1;
				int potential= 0;
				if (m[j] - m[i] < k) { /*m[j] and m[i] cannot both be used for location */
					/* if we are here, consider the built situation when m[i] was skipped */
					if (i > 0)
						potential = p[j] + built[path[i]];
					else
						potential = p[j];
					if (potential > built[j]) {  /* a previous iteration found a better path */
						built[j] = potential;
						path[j] = path[i]; 
					}				
				}else {
					potential = p[j] + built[i];
					if (potential > built[j]) {
						built[j] = potential;
						path[j] = i;
					}
				}
				if (potential > max) {
					max = j;
				}
		}
		int ret = built[max];
		System.out.println(ret);
		while (max > 0) {
			System.out.print(max);
			max = path[max];
		}
		System.out.println(0);
		PracticeUtils.printArray(1, built);
		PracticeUtils.printArray(1, path);
		return ret;
	}
	
	public static void main(String[] args) {
		int[] m = new int[] {1, 2, 4, 6, 7};
		int[] p = new int[] {20, 40, 100, 200, 300}; 
		int k = 3;
		Yuckdonalds lis1 = new Yuckdonalds(m, p, k);
		boolean correct = 420 == lis1.solve();
		System.out.println(correct);
		
	}
}

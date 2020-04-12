package dynamicprogramming;

public class Template {

	int[] in;

	public Template(int[] in) {
		this.in = in;
	}

	public int solve() {
		return 0;
	}

	public static void main(String[] args) {
		int[] in1 = new int[] {1,2,3};
		Template lis1 = new Template(in1);
		int answer1 = lis1.solve();
		System.out.println(answer1);		
	}
}

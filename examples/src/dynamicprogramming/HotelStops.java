package dynamicprogramming;

public class HotelStops {
	
	int[] in;
	
	public HotelStops(int[] in) {
		this.in = in;
	}
	
	public int solve() {
		int[] saved = new int[in.length];
		for (int i = 0; i < in.length - 1; i++) {
			saved[i] = Integer.MAX_VALUE;
		}
		for (int i = in.length-1; i >= 0; i--) {
			for (int j = i -1; j >= 0; j--) {
				saved[j] = Math.min(saved[j], saved[i] + (int)Math.pow(200 - (in[i] - in[j]),2));
			}
		}
		PracticeUtils.printArray(1, saved);
		return saved[0];
	}
	
	public static void main(String[] args) {
		int[] in1 = new int[] {0, 50,100,200};
		HotelStops lis1 = new HotelStops(in1);
		boolean correct = 0 == lis1.solve();
		System.out.println(correct);
		int[] in2 = new int[] {0, 200, 400, 600, 601};
		HotelStops lis2 = new HotelStops(in2);
		correct = 1 == lis2.solve();
		System.out.println(correct);
	
		
		
	}
}

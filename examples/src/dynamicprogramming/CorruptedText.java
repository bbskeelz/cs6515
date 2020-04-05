package dynamicprogramming;

import org.apache.commons.lang3.ArrayUtils;

public class CorruptedText {

	String in;

	public static String[] dict = {"A", "AAB", "C", "BCC"};

	public CorruptedText(String in) {
		this.in = in;
	}

	public String solve() {
		boolean[] good = new boolean[in.length()+1];
		good[0] = true; /* empty sequence is valid */
		int n = in.length();
		for (int i = 1; i <= n; i++ ) {
			for (int j = i; j > 0; j--) {
				if (d(j-1,i) && good[j-1])
					good[i] = true;
			}
		}
		if (good[n]) {
			char[] inChar = in.toCharArray();
			StringBuilder sb = new StringBuilder().append("Proper text: ");
			for (int i = 0; i < inChar.length; i++) {
				if (!good[i+1] && good[i]) {
					sb.append(" ");
				}
				sb.append(inChar[i]);
			}
			return sb.toString();
		}else {
			return "not a valid string";
		}
	}

	public boolean d(int i, int j) {
		String text = in.substring(i,j);
		return (ArrayUtils.contains(dict, text));
	}

	public static void main(String[] args) {
		String in1 = "AABBCC";
		CorruptedText lis1 = new CorruptedText(in1);
		boolean correct = "Proper text: AAB BCC".equals(lis1.solve());
		System.out.println(correct);

	}
}

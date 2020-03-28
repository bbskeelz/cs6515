package dynamicprogramming;

import java.util.Arrays;
public class PracticeUtils {

	public static void printArray(int dimension, Object array) {
		if (dimension < 1) 
			return;
		if (dimension == 1) {
			System.out.print(Arrays.toString((int[]) array));
		}else {
			Object[] arr = (Object[]) array;
			for (int i = 0; i < arr.length; i++) {
				printArray(dimension -1, arr[i]);
				System.out.println();
			}
		}
	}
}

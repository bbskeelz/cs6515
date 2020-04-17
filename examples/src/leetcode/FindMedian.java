package leetcode;

public class FindMedian {
	
	public static void main(String[] args) {
		int[] in1 = new int[] {1,2,3,4,5,6,7};
		int[] in2 = new int[] {8,9,10};
		new FindMedian().findMedianSortedArrays(in1, in2);
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] l = null;
		int[] r = null;
		int ln=0, rn=0;
		if (nums1.length > nums2.length) {
			l = nums1; r = nums2;
			ln = nums1.length; rn = nums2.length;
		}
		int n = ln + rn;
		int[] prevPtr = l;
		int[] currPtr = r;
		int[] swap;
		int prev = ln/2; int curr = rn/2;
		int swapIndex;
		boolean odd = n % 2 == 1;
		int ret1 = -1;
		int i, j;
		int less = 0; int more = 0;
		while(true) {
			i = prevPtr[prev];
			j = currPtr[curr];
			swap = prevPtr;
			swapIndex = prev;
			if (i < j) {
				less = prev;
				more = prevPtr.length - prev - 1 + currPtr.length - curr;
				prev = curr;
				curr = ((swap.length-1) - swapIndex) / 2 + swapIndex+1;
				prevPtr = currPtr;
				if (swapIndex < swap.length-1) {
					currPtr = swap;
				}
			}else {
				less = prev + curr + 1;
				more = prevPtr.length - prev - 1;
				prev = curr;
				curr = (swapIndex / 2);
				prevPtr = currPtr;
				if (swapIndex != 0) {
					currPtr = swap;
				}

			}
			if (less + more == n -1 && Math.abs(less-more) == 1) { 
				if (odd)
					return swap[swapIndex];
				else {
					if (ret1 >= 0) {
						return (double)(ret1 + swap[swapIndex]) / 2;
					}else {
						ret1 = swap[swapIndex];
					}
				}
			}
		}
	}
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

	int[] nums;

	public ThreeSum(int[] nums) {
		this.nums = nums;
	}

	public List<List<Integer>> solve() {
		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> ret = new ArrayList<>();
		if (n < 3) return ret;
		if (nums[0] > 0) return ret;
		if (nums[n-1] < 0) return ret;
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			indexMap.put(nums[i], i);
		}
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			for (int j = i+1; j < n; j++ ) {
				if (j > i + 1 && nums[j] == nums[j-1]) {
					continue;
				}
				int k = nums[i] + nums[j];
				if (nums[i] <= 0 && nums[j] > 0)
					break;
				List<Integer> retItem = new ArrayList();
				if (indexMap.get(0-k) != null) {
					if (indexMap.get(0-k) == i || indexMap.get(0-k) == j)
						continue;
					retItem.add(nums[i]);
					retItem.add(nums[j]);
					retItem.add(nums[indexMap.get(0-k)]);
					ret.add(retItem);
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[] in1 = new int[] {-1, 0, 1, 0};
		ThreeSum lis1 = new ThreeSum(in1);
		lis1.solve();
	}
}

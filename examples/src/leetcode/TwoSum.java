package leetcode;

import java.util.*;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/


public class TwoSum {

	int[] in;
    int target;

	public TwoSum(int[] in, int target) {
		this.in = in;
        this.target = target;
	}

	public int[] solve() {
        Map<Integer, Integer> saved = new HashMap<>();
        for (int i = 0; i < in.length; i++){
            if (saved.get(target - in[i]) != null){
                return new int[]{saved.get(target - in[i]), i};
            }else{
                saved.put(in[i], i);
            }
        }
        return new int[]{0,0};
	}

	public static void main(String[] args) {
		int[] in1 = new int[] {1,2,3};
        int target = 5;
		TwoSum lis1 = new TwoSum(in1, 5);
		int[] answer1 = lis1.solve();
		System.out.println(answer1[0] + "," + answer1[1]);
	}
}

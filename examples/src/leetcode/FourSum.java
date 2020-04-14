package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FourSum {

	int[] nums;
	int target;

	public FourSum(int[] nums, int target) {
		this.nums = nums;
		this.target = target;
	}

    public List<List<Integer>> solve() {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        Map<Integer, Set<Edge>> saved = new HashMap<>();
        Set<Edge> retEdges = new HashSet<>();
        for (int i = 0; i < n; i++) {
        	for (int j = i+1; j < n; j++) {
        		Set<Edge> dEdges = saved.computeIfAbsent(nums[i]+nums[j], v -> new HashSet<>());
        		Set<Integer> nodes = new TreeSet<>();
        		nodes.add(i); nodes.add(j);
        		Edge ij = new Edge(2, nodes, nums);
        		dEdges.add(ij);
        		Set<Edge> nEdges = saved.get(target - (nums[i] + nums[j]));
        		if (nEdges == null || nEdges.isEmpty())
        			continue;
        		else {
        			for (Edge e : nEdges) {
        				Set<Integer> retNodes = new TreeSet<>();
        				retNodes.addAll(nodes);
        				retNodes.addAll(e.nodes);
        				if (retNodes.size() < 4) {
        					continue;
        				}
        				Edge ijkl = new Edge(4, retNodes, nums);
        				retEdges.add(ijkl);
        			}
        		}
        	}
        }
		for (Edge e : retEdges) {
			ret.add(e.values);
		}
		return ret;
    }

	public static void main(String[] args) {
		int[] in1 = new int[] {-1,0,1,0,-2,2};
		int target = 0;
		FourSum lis1 = new FourSum(in1, target);
		Object answer1 = lis1.solve();
		System.out.println(answer1);		
	}
	

}

class Edge {
	int depth;
	Set<Integer> nodes;
	int[] nums;
	List<Integer> values;
	public Edge(int depth, Set<Integer> nodes, int[] nums) {
		this.depth = depth;
		this.nodes = nodes;
		this.nums = nums;
		values = new ArrayList<>();
		for (Integer i : nodes) {
			values.add(nums[i]);
		}
	}
	@Override
	public boolean equals(Object obj) {
		Edge other = (Edge) obj;
		if (this.depth != other.depth) {
			return false;
		}
		if (this.nodes.size() != other.nodes.size()) {
			return false;
		}
		if (depth == 4) {
//			Collections.sort(this.values);
//			Collections.sort(other.values);
			for (int i = 0; i < depth; i++) {
				if (!this.values.get(i).equals(other.values.get(i)))
					return false;
			}
		}else {
			for (int n : this.nodes) {
				if (!other.nodes.contains(n)) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return -1;
	}
	
}

package mina.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：https://leetcode-cn.com/problems/permutations/
 * <p>
 * 全排列，没有重复数字
 * 典型回溯算法
 */


public class Permute_46 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList();
        backtrack(nums, track);

        for (int k = 0; k < result.size(); k++) {
            System.out.println(result.get(k));
        }

        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permute_46 p = new Permute_46();
        p.permute(nums);
    }
}

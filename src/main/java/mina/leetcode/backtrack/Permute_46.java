package mina.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/permutations/

public class Permute_46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        Permute_46 p = new Permute_46();
        p.permute(nums);

        for(int k=0; k< p.result.size(); k++) {
            System.out.println(p.result.get(k));
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        LinkedList<Integer> track = new LinkedList();
        backtrack(nums, track);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if(track.contains(nums[i])) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }

}

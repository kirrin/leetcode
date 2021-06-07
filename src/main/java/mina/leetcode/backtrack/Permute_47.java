package mina.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：https://leetcode-cn.com/problems/permutations-ii/
 * <p>
 * 全排列，带重复数字
 * <p>
 * 先排序，再选择数字，保证在填第idx个数的时候重复数字只会被填入一次即可
 */
public class Permute_47 {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        List<Integer> track = new ArrayList(nums.length);

        backtrack(nums, track, 0);

        for (int k = 0; k < result.size(); k++) {
            System.out.println(result.get(k));
        }
        return result;
    }

    private void backtrack(int[] nums, List<Integer> track, int index) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如何剪枝，剪去重复的分支
            // !visit[i-1] 和 visit[i-1] 结果一样，
            // 为什么要加这个呢? 试了不加的话track填不满，只有加了，才能填满
            // i和i-1相等时，如果i-1已经使用过，那可以继续，如果i-1未被使用过，那么继续用i就会产生重复分支，需要被剪枝
            if (visit[i] || i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            visit[i] = true;
            backtrack(nums, track, index + 1);
            track.remove(index);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};

        Permute_47 p = new Permute_47();
        p.permute(nums);

    }
}

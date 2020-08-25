package com.waibizi.solution_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 歪鼻子
 * @Date 2020/7/25 11:01
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}

package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/8/30 13:38
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int[] fliter(int[] nums){
        if (nums.length == 0) return new int[]{};
        int flag = nums[0];
        int[] res = new int[nums.length];
        res[0] = nums[0];

        int index = 1;
        for (int i = 0; i < nums.length; i++){
            if (i == 0)
                continue;
            if (nums[i] != flag){
                res[index++] = nums[i];
            }
            flag = nums[i];
        }
        return res;
    }
}

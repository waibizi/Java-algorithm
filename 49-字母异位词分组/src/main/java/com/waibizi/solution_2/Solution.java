package com.waibizi.solution_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @Author 歪鼻子
 * @Date 2020/9/3 21:39
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Long,List<String>> map = new HashMap<>();
        /* 这个是26个质数，英文有26个字母 */
        long[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++){
            long key = 1;
            for (int j = 0; j < strs[i].length(); j++){
                /* 每个字符串数组的每个单个字符减去首字母（ASCII码） */
                key *= prime[strs[i].charAt(j)-'a'];
            }
            if (map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }
        }
        List<List<String>> list =new ArrayList<>(map.values());
        return list;
    }
}

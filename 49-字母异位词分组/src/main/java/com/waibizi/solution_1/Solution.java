package com.waibizi.solution_1;

import java.util.*;

/**
 * @Author 歪鼻子
 * @Date 2020/9/3 17:04
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        boolean[] flag = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            List<String> cache = null;
            if(!flag[i]){
                cache = new ArrayList<>();
                cache.add(strs[i]);
                for(int j = i+1; j < strs.length; j++){
                    if(judge(strs[i],strs[j])){
                        flag[j] = true;
                        cache.add(strs[j]);
                    }
                }
            }
            if(cache!=null){
                Collections.reverse(cache);
                result.add(cache);
            }
        }
        return result;
    }

    /**
     如果这两个是异构的话，我们就返回true
     **/
    private  boolean judge(String argsA,String argsB){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i <argsA.length(); i++ ){
            if(map.containsKey(argsA.charAt(i))){
                map.put(argsA.charAt(i),map.get(argsA.charAt(i))+1);
            }else{
                map.put(argsA.charAt(i),1);
            }
        }
        for(int i = 0; i <argsB.length(); i++ ){
            if(map.containsKey(argsB.charAt(i))){
                map.put(argsB.charAt(i),map.get(argsB.charAt(i))-1);
            }else{
                return false;
            }
        }
        Set<Character> set = map.keySet();
        for(char c: set){
            if((map.get(c))!=0){
                return false;
            }
        }
        return true;
    }
}

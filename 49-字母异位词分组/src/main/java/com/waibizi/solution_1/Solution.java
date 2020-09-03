package com.waibizi.solution_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author 歪鼻子
 * @Date 2020/9/3 17:04
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public List<List<String>> Solution(String[] args){
        List<List<String>> result = new ArrayList<>();
        boolean[] flag = new boolean[args.length];
        for(int i = 0; i < args.length; i++){
            List<String> cache = null;
            if(!flag[i]){
                cache = new ArrayList<>();
                for(int j = 0; j < args.length; j++){
                    if(judge(args[i],args[j])){
                        flag[j] = true;
                        cache.add(args[i]);
                    }
                }
            }
            if(cache!=null){
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
                map.put(argsB.charAt(i),1);
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

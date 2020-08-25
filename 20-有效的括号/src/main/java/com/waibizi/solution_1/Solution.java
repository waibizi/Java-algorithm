package com.waibizi.solution_1;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author 歪鼻子
 * @Date 2020/7/24 23:06
 * @Description: 思路很简单，先把需要适配的内容用一个东西存起来，例如hashmap的key跟value形式刚刚好，
 *               然后利用栈的特点，将需要比较的字符数分割为字符，如果是key就入栈，不然就直接将字符与pop的值比较
 * @Version 1.0
 */
public class Solution {
    private static HashMap<Character,Character> hashMap = new HashMap<>();
    public boolean isValid(String s) {
        hashMap.put('[',']');
        hashMap.put('{','}');
        hashMap.put('(',')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (hashMap.containsKey(c)){
                stack.push(c);
            }else{
                if (stack.isEmpty()) return false;
                if (c != hashMap.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }
}

package com.waibizi.solution1;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

import java.util.Arrays;

/**
 * @Author 歪鼻子
 * @Date 2020/9/3 11:14
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        return sort(arr,0,arr.length-1,k-1);
    }
    private int[] sort(int[] arr,int begin,int end,int k){
        int mid = pivotIndex(arr,begin,end);
        if (mid == k) return Arrays.copyOf(arr,k);
        return mid > k ? sort(arr,begin,mid-1,k) : sort(arr,begin,mid,k);
    }
    private int pivotIndex(int[] arr,int begin,int end){
        int pivot = arr[begin];
        while (begin<end){
            while (begin<end){
                if (pivot<arr[end]){
                    end--;
                }else {
                    arr[begin++] = arr[end];
                    break;
                }
            }
            while (begin<end){
                if (pivot>arr[begin]){
                    begin++;
                }else {
                    arr[end--] = arr[begin];
                    break;
                }
            }
        }
        arr[begin] = pivot;
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        new Solution().getLeastNumbers(arr,2);
    }
}

package com.itzyh.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有2个顺序排列好的整数数组array1、array2，编写程序合并这两个数组为一个排序排列好的数组。
 * 比如：array1为[1,2,3,5]，array2为[1,3,4]，合并后的结果为[1,1,2,3,3,4,5]。
 */
public class Test{
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int[] arr2 = {1,3,4};

        int arr_length = arr.length;
        int arr2_length = arr2.length;
        int[] newArr = new int[arr_length+arr2_length];
        // 将第一个数组复制到新数组中，
        // 第一个参数代表源数组，第二个代表从哪开始复制，第三个代表目标数组，第四个代表目标数组从哪开始填充
        // 第五个参数代表，复制的长度。
        System.arraycopy(arr,0,newArr,0,arr_length);
        System.arraycopy(arr2,0,newArr,arr_length,arr2_length);
        Arrays.sort(newArr);
        System.out.println(Arrays.toString(newArr));


        // 合并字符串，通过集合方式
        String[] a = { "A", "B", "C" };
        String[] b = { "E", "F" };
        List<String> list = Arrays.asList(a);
        List<String> list01 = new ArrayList<String>(list);
		/* 不能直接list.addAll(Arrays.asList(b));
			因为Arrays.asList返回的ArrayList与java.util.List中的ArrayList不同*/
        list01.addAll(Arrays.asList(b));
        Object[] array = list01.toArray();
        System.out.println(Arrays.toString(array));


    }
}
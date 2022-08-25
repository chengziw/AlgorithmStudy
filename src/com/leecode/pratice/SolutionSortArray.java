package com.leecode.pratice;

import java.util.*;

class SolutionSortArray {
    private final static String PUSH = "Push";
    private final static String POP = "Pop";


    public static void main(String args[]) {
        int[] input = new int[]{1, 2, 3, 5, 7, 6, 4, 8, 9};
        int[] output = getOutputArray(input);
        System.out.println(Arrays.toString(output));
    }


    public static int[] getOutputArray(int[] input) {
        if (input == null || input.length < 2){
            return input;
        }
        int[] output = new int[input.length];
        Set<Integer> set = new HashSet<>();
        // num是期待递增的值  index 函数A输入值的下标
        for (int num = 1, index = 0; num <= input.length && index < input.length; index++) {
            // 缓存非期待值
            if (num != input[index]) {
                set.add(input[index]);
            } else {
                //缓存结果并移动游标
                output[num - 1] = num;
                num++;

                //判断是否有缓存数据
                while (set.contains(num)) {
                    set.remove(num);
                    output[num - 1] = num;
                    num++;
                }
            }
        }
        return output;
    }




    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        // num是产生的数字，index 是 target 数组的下标
        for (int num = 1, index = 0; num <= n && index < target.length; ++num) {
            // 不管是否符合要求，先把数和操作放进来
            stack.add(num);
            ans.add(PUSH);
            // 检查一下是否符合要求，如果不符合，那么就把栈顶元素弹出来，然后再加入Pop操作
            if (target[index] != stack.peek()) {
                Integer pop = stack.pop();
                set.add(pop);
                ans.add(POP);
            } else {
                // 符合要求的话，就把游标往右移动一个
                index++;
                while (set.contains(index + 1)) {
                    stack.add(index + 1);
                    set.remove(index + 1);
                    index++;
                }
            }
        }
        stack.forEach(System.out::println);
        return ans;
    }

    public static int[] buildArray1(int[] input) {
        if (input == null || input.length < 2){
            return input;
        }
        int[] output = new int[input.length];
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        // num是期待递增的值  index 函数A输入值的下标
        for (int num = 1, index = 0; num <= input.length && index < input.length; index++) {
            // 数据入栈
            stack.add(input[index]);
            // 数据 为非期待值 那么就把栈顶元素弹出来，然后再加入Pop操作
            if (num != stack.peek()) {
                Integer pop = stack.pop();
                set.add(pop);
            } else {
                // 符合要求的话，就把游标往右移动一个
                output[num-1] = num;
                num++;
                while (set.contains(num)) {
                    stack.add(num);
                    set.remove(num);
                    output[num] = num;
                    num++;
                }
            }
        }
        return output;
    }

}
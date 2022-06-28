package com.leecode.month.month_06;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_06
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/6/6 20:48
 * @version: 1.0.0
 */
public class Day_06 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] nums = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int temp = domino[0] > domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += nums[temp];
            nums[temp]++;
        }
        return ret;
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlant(A.size() - 1, A, B, C);
    }

    public void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        movePlant(size - 1, start, target, auxiliary);
        target.add(start.remove(start.size() - 1));
        movePlant(size - 1, auxiliary, start, target);
    }

    @Test
    public void testStackReverse() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        Integer t = deleteAndReturnStack(stack);
        reverseStack(stack);
        stack.push(t);
    }

    public int deleteAndReturnStack(Stack<Integer> stack) {
        int temp = stack.pop();
        if (stack.isEmpty()) {
            return temp;
        }
        int t = deleteAndReturnStack(stack);
        stack.push(temp);
        return t;
    }


}

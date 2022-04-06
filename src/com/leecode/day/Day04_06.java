package com.leecode.day;

import com.leecode.dto.Util;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.day
 * @author: wangzicheng
 * @description: https://leetcode-cn.com/problems/minimum-height-trees/solution/zui-xiao-gao-du-shu-by-leetcode-solution-6v6f/
 * @date: 2022/4/6 19:57
 * @version: 1.0.0
 */
public class Day04_06 {
    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<Integer>();
            if (n == 1) {
                ans.add(0);
                return ans;
            }
            List<Integer>[] adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            for (int[] edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }

            int[] parent = new int[n];
            Arrays.fill(parent, -1);
            /* 找到与节点 0 最远的节点 x */
            int x = findLongestNode(0, parent, adj);
            /* 找到与节点 x 最远的节点 y */
            int y = findLongestNode(x, parent, adj);
            /* 求出节点 x 到节点 y 的路径 */
            List<Integer> path = new ArrayList<Integer>();
            parent[x] = -1;
            while (y != -1) {
                path.add(y);
                y = parent[y];
            }
            int m = path.size();
            if (m % 2 == 0) {
                ans.add(path.get(m / 2 - 1));
            }
            ans.add(path.get(m / 2));
            return ans;
        }

        public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
            int n = adj.length;
            Queue<Integer> queue = new ArrayDeque<Integer>();
            boolean[] visit = new boolean[n];
            queue.offer(u);
            visit[u] = true;
            int node = -1;

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                node = curr;
                for (int v : adj[curr]) {
                    if (!visit[v]) {
                        visit[v] = true;
                        parent[v] = curr;
                        queue.offer(v);
                    }
                }
            }
            return node;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        if (score == null || score.length < 1) {
            return null;
        }

        for (int i = 0; i < score.length; i++) {
            heapInsert(score, i);
        }

        int heapIndex = score.length - 1;
        Util.swap(score, 0, heapIndex);
        while (heapIndex > 0) {
            headIfy(score, 0, heapIndex);
            Util.swap(score, 0, --heapIndex);
        }
        return null;
    }

    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Util.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void headIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;

            if (index == largest) {
                break;
            }
            Util.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;

        }
    }
}

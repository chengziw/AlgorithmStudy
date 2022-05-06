package com.leecode.month.month_03;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.day
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/3/30 17:24
 * @version: 1.0.0
 */
public class Day03_30 {

    /**
     * create by: wangzicheng
     * description: https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/
     * create time: 2022/3/30 17:25
     * version: v1.0.0
     */
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        if (k < 0 || arrival == null || load == null) {
            return null;
        }
        TreeMap<Integer, Integer> record = new TreeMap<>();
        Map<Integer, Integer> kMap = new HashMap(k);
        for (int i = 0; i < k; i++) {
            kMap.put(i, 0);
            record.put(i, 0);
        }

        for (int i = 0; i < arrival.length; i++) {
            int t = i % k;
            System.out.print("目标服务器：" + t + "---");
            Integer value = arrival[i] + load[i];
            if (kMap.get(t) < arrival[i]) {
                kMap.put(t, value);
                record.put(t, record.get(t) + 1);
                System.out.println("服务器：" + t + "执行第：" + i + "次任务,任务完成时间：" + value);
            } else {
                boolean bflag = false;
                boolean aflag = false;
                int temp = -1;
                for (Map.Entry<Integer, Integer> entry : kMap.entrySet()) {
                    Integer key = entry.getKey();
                    Integer v = entry.getValue();
                    if (key > t) {
                        if (v <= arrival[i]) {
                            kMap.put(key, value);
                            record.put(key, record.get(key) + 1);
                            System.out.println("服务器：" + t + "执行第：" + i + "次任务,任务完成时间：" + value);
                            bflag = true;
                        }
                    } else if (temp < 0 && !bflag && !aflag) {
                        if (v < arrival[i]) {
                            temp = key;
                            aflag = true;
                        }
                    }

                }

                if (!bflag && aflag && temp >= 0) {
                    kMap.put(temp, value);
                    record.put(temp, record.get(temp) + 1);
                    System.out.println("服务器：" + temp + "执行第：" + i + "次任务,任务完成时间：" + value);
                }
                //  System.out.println("无服务器执行第："+i+"次任务,任务完成时间："+value);
            }
            System.out.println();

        }
        System.out.println("-----");

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            System.out.println(entry.getKey()+"-----"+entry.getValue());
            max = max < entry.getValue() ? entry.getValue() : max;
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : record.entrySet()) {
            if (entry.getValue() == max) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    @Test
    public void test() {
        int k = 4;
        int[] arr = {1,3,4,5,10,12};
        int[] load = {11,9,3,1,9,12};
        List<Integer> result = busiestServers(k, arr, load);
        List<Integer> result1 = busiestServers1(k, arr, load);
        System.out.println("----------答案对比-----------");
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(Arrays.toString(result1.toArray()));
    }


    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<Integer>();
        for (int i = 0; i < k; i++) {
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            Integer p = available.ceiling(i % k);
            if (p == null) {
                p = available.first();
            }
            requests[p]++;
            busy.offer(new int[]{arrival[i] + load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }


}

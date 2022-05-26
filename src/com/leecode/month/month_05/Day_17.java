package com.leecode.month.month_05;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @projectName: AlgorithmStudy
 * @package: com.leecode.month.month_05
 * @author: wangzicheng
 * @description: TODO
 * @date: 2022/5/17 19:16
 * @version: 1.0.0
 */
public class Day_17 {
    public boolean isAlienSorted(String[] words, String order) {

        if (words == null || order == null) {
            return true;
        }

        Arrays.sort(words);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];
            int index = 0;
            while (index < left.length() && index < right.length()) {
                if (map.get(left.charAt(index)) == map.get(right.charAt(index))) {
                    index++;
                } else if (map.get(left.charAt(index)) > map.get(right.charAt(index))) {
                    return false;
                } else {
                    break;
                }
            }
            if (left.length() > right.length() && left.startsWith(right)) {
                return false;
            }
        }
        return true;
    }


    public int minimumMoves(String s) {
        if (s == null) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                ans++;
            }
        }
        return ans;
    }

    public int maxDistance(int[] colors) {
        if (colors == null) {
            return 0;
        }

        int length = colors.length;
        if (colors[0] != colors[length - 1]) {
            return colors.length;
        }

        int left = 1;
        while (colors[0] == colors[left]) {
            left++;
        }

        int right = length - 2;
        while (colors[right] == colors[length - 1]) {
            right--;
        }

        return Math.max(right, length - 1 - left);
    }

    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int ans = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            ans += cost[i--];
            if (i >= 0) {
                ans += cost[i--];
            }
        }

        return ans;
    }

    public int minimumSum(int num) {
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = num % 10;
            num /= 10;
        }
        Arrays.sort(a);
        return 10 * (a[0] + a[1]) + a[2] + a[3];
    }

    public int convertTime(String current, String correct) {
        String[] cur = current.split(":");
        int cur_hour = Integer.parseInt(cur[0]), cur_min = Integer.parseInt(cur[1]);
        String[] corr = correct.split(":");
        int corr_hour = Integer.parseInt(corr[0]), corr_min = Integer.parseInt(corr[1]);
        // 计算差距分钟数
        int minutes = (60 - cur_min) + (corr_hour - cur_hour - 1) * 60 + corr_min;
        // 对分钟数直接除就可以
        int res = 0;
        // 贪心求解
        if (minutes >= 60) {
            res += minutes / 60;
            minutes %= 60;
        }
        if (minutes >= 15) {
            res += minutes / 15;
            minutes %= 15;
        }
        if (minutes >= 5) {
            res += minutes / 5;
            minutes %= 5;
        }
        if (minutes >= 1) {
            res += minutes;
        }
        return res;

    }


    public String removeDigit(String number, char digit) {
        int n = number.length();
        StringBuilder sb = new StringBuilder();
        int removeIdx = -1;
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                removeIdx = i;
                if (i < n - 1 && number.charAt(i + 1) > digit) {
                    break;
                }
            }
        }
        sb.append(number.substring(0, removeIdx))
                .append(number.substring(removeIdx + 1));
        return sb.toString();
    }

    public int storeWater(int[] bucket, int[] vat) {
        int maxVat = 0;
        for (int v : vat) maxVat = Math.max(v, maxVat);
        if (maxVat == 0) return 0; //最大容量为0，代表不需蓄水，直接返回0
        int ans = 10001;
        for (int pour = 1; pour <= 10000; pour++) { //枚举倒水次数1-10000
            if (pour >= ans) break;
            int upgrade = 0;
            for (int i = 0; i < vat.length; i++) { //枚举每个水桶，计算总升级次数
                int cur = (int)Math.ceil((double)vat[i] / pour - bucket[i]); //容量/倒水次数-初始蓄水量=升级次数
                upgrade += cur > 0 ? cur : 0;
                if (upgrade >= ans) break;
            }
            ans = Math.min(ans, upgrade + pour); //倒水次数 + 总升级次数 = 总次数
        }
        return ans;
    }
}

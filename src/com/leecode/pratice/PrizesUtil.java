package com.leecode.pratice;

import java.util.*;

public class PrizesUtil {

    public static Prizes drawPrice(List<Prizes> prizesList) {
        if (prizesList.isEmpty()) {
            throw new NullPointerException();
        }
        int size = prizesList.size();

        //奖品总概率
        double sumRates = 0d;
        for (Prizes award : prizesList) {
            sumRates += award.getPrizesRate();
        }

        //单个奖品的概率 区间段
        List<Double> sortPrizesRateList = new ArrayList<>(size);
        double tempSumRates = 0d;
        for (Prizes prize : prizesList) {
            tempSumRates += prize.getPrizesRate();
            sortPrizesRateList.add(tempSumRates / sumRates);
        }

        double randomDouble = Math.random();

        //排序后，对应位置为中奖商品位置
        sortPrizesRateList.add(randomDouble);
        Collections.sort(sortPrizesRateList);
        int lotteryIndex = sortPrizesRateList.indexOf(randomDouble);
        return prizesList.get(lotteryIndex);
    }

    public static void main(String[] args) {
        List<Prizes> prizesList = new ArrayList<>();
        prizesList.add(new Prizes("10个积分", 0.35d));
        prizesList.add(new Prizes("33个积分", 0.25d));
        prizesList.add(new Prizes("5元红包", 0.002d));
        prizesList.add(new Prizes("20元话费", 0.003d));
        prizesList.add(new Prizes("京东100元购物卡", 0.0005d));
        prizesList.add(new Prizes("未中奖", 0.1d));

        Map<String, Integer> result = new HashMap<>();
        //测试次数
        int sum = 100000;
        for (int i = 0; i < sum; i++) {
            Prizes award = drawPrice(prizesList);
            String title = award.getPrizesName();
            Integer count = result.get(title);
            result.put(title, count == null ? 1 : count + 1);
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ", 中奖次数：" + entry.getValue() + ", 中奖概率：" + (entry.getValue().doubleValue() / sum));
        }
    }

    public static class Prizes {

        private String prizesId;

        private String prizesName;

        private double prizesRate;

        public Prizes() {
        }

        public Prizes(String prizesName, double prizesRate) {
            this.prizesName = prizesName;
            this.prizesRate = prizesRate;
        }

        public String getPrizesId() {
            return prizesId;
        }

        public void setPrizesId(String prizesId) {
            this.prizesId = prizesId;
        }

        public String getPrizesName() {
            return prizesName;
        }

        public void setPrizesName(String prizesName) {
            this.prizesName = prizesName;
        }

        public double getPrizesRate() {
            return prizesRate;
        }

        public void setPrizesRate(double prizesRate) {
            this.prizesRate = prizesRate;
        }
    }
}

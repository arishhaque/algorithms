package com.algos.greedy;

import java.util.Arrays;

public class FractionalKnapsack {

    class Item{

        private int weight;
        private int value;
        private double ratio;

        public Item() {
            this.weight = 0;
            this.value = 0;
            this.ratio = 0;
        }
    }

    public int maxProfit(int[] wt, int[] val, int W) {

        int n = wt.length;
        Item[] itemArr = new Item[n];

        for(int i=0; i<n; i++) {

            itemArr[i] = new Item();
            itemArr[i].value = val[i];
            itemArr[i].weight = wt[i];
            itemArr[i].ratio = (double) val[i] / (double) wt[i];
        }
        // sort based on highest ratio to lowest
        Arrays.sort(itemArr, (o1, o2) -> (int) (o2.ratio - o1.ratio));

        int profit = 0;
        for(int i=0; i<n; i++) {

            if(W >= itemArr[i].weight) {

                W = W - itemArr[i].weight;
                profit += itemArr[i].value;

            } else {

                double fraction = (double) W / (double)itemArr[i].weight;
                profit += (int) (fraction * itemArr[i].value);
                break;
            }
        }
        return profit;
    }


    public static void main(String[] args) {

        FractionalKnapsack fk = new FractionalKnapsack();

        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;

        int res = fk.maxProfit(wt, val, W);
        System.out.println(res);
    }
}

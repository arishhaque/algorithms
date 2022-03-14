package com.algos.greedy;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeGD {

    public List<Integer> coinChangeUsingGreedy(int[] coins, int amount) {

        List<Integer> res = new ArrayList<>();
        while(amount > 0) {

            int s = 0;
            for (int coin : coins) {

                if (coin <= amount) {
                    s = Math.max(s, coin);
                }
            }
            amount = amount - s;
            res.add(s);
        }
        System.out.println(res.toString());
        return res;
    }

    public static void main(String[] args) {

        CoinChangeGD cc = new CoinChangeGD();
        int[] coins = new int[]{1, 5, 10, 15, 20};
        int amount = 14;
        cc.coinChangeUsingGreedy(coins, amount);
    }
}

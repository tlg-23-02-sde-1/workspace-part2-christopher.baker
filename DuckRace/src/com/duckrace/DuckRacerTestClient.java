package com.duckrace;

import java.util.List;

import static com.duckrace.Reward.*;

class DuckRacerTestClient {

    public static void main(String[] args) {
        DuckRacer racer5 = new DuckRacer(5, "Chris");
        System.out.println(racer5);

        racer5.win(PRIZES);
        racer5.win(PRIZES);
        racer5.win(DEBIT_CARD);
        racer5.win(DEBIT_CARD);
        racer5.win(PRIZES);

        System.out.println(racer5);

        List<Reward> reward = racer5.getRewards();

        //rewards.add(prizes);
        racer5.win(PRIZES);
        racer5.win(PRIZES);

        System.out.println(reward);

    }
}
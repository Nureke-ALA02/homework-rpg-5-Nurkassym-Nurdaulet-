package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward";
        }
        if (battleResult.getWinner() == null) {
            return "No reward";
        }
        if (battleResult.getWinner().toLowerCase().contains("hero")) {
            return "100 gold and epic loot";
        }
        return "No reward";
    }
}
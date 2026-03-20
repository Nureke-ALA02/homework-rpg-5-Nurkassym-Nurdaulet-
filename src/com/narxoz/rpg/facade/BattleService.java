package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);
    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds = 0;
        while (hero.isAlive() && boss.isAlive() && rounds < 10) {
            rounds++;
            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);
            result.addLine(hero.getName() + " uses " + action.getActionName()
                    + " dealing " + heroDamage + " damage");
            if (!boss.isAlive()) {
                result.setWinner(hero.getName());
                break;
            }
            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName() + " hits back for " + bossDamage);

            if (!hero.isAlive()) {
                result.setWinner(boss.getName());
                break;
            }
            random.nextInt(1);
        }
        result.setRounds(rounds);
        return result;
    }
}
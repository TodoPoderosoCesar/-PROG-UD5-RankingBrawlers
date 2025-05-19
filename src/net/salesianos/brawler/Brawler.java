package net.salesianos.brawler;

public class Brawler {
    
    public String name;
    public String rarity;
    public int health;
    public int attack;
    public int defense;
    public int speed;
    public int rank;
    
    public Brawler(String name, String rarity, int health, int attack, int defense, int speed, int rank) {
        this.name = name;
        this.rarity = rarity;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Brawler [name=" + name + ", rarity=" + rarity + ", health=" + health + ", attack=" + attack
                + ", defense=" + defense + ", speed=" + speed + ", rank=" + rank + "]";
    }
    
    
}

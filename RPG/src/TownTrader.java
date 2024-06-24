class TownTrader extends Character {
    int potionPrice = 30;

    public TownTrader(String name, int health, int strength, int agility, int gold) {
        super(name, health, strength, agility);
        this.gold = gold;
    }
}
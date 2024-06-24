import java.util.Random;

class Character {
    String name;
    int health;
    int strength;
    int agility;
    int gold = 0;
    int experience = 0;

    public Character(String name, int health, int strength, int agility) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
    }

    public void attack(Character enemy) {
        Random random = new Random();
        int chanceToHit = agility * 3;
        int randomValue = random.nextInt(100);

        if (chanceToHit > randomValue) {
            enemy.health -= strength;
            System.out.println(name + " наносит " + enemy.name + " " + strength + " урона!");
        } else {
            System.out.println(name + " промахнулся!");
        }
    }

    public void levelUp() {
        if (experience >= 100) {
            experience -= 100;
            strength++;
            agility++;
            health += 10;
            System.out.println(name + " повышает уровень!");
        }
    }

    public void buyPotion(TownTrader trader) {
        if (gold >= trader.potionPrice) {
            gold -= trader.potionPrice;
            trader.gold += trader.potionPrice;
            System.out.println(name + " покупает зелье у " + trader.name);
            health += 20;
            System.out.println(name + " исцеляется");
        } else {
            System.out.println("Недостаточно денег для покупки зелья!");
        }
    }
}

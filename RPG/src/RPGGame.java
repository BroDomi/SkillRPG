import java.util.Random;
import java.util.Scanner;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру!");
        System.out.print("Введите имя персонажа: ");
        String playerName = scanner.nextLine();
        Character player = new Character(playerName, 100, 10, 20);
        TownTrader trader = new TownTrader("Торговец", 50, 5, 15, 100);

        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К торговцу");
        System.out.println("2. В Темный лес");
        System.out.println("3. На выход");

        int choice = scanner.nextInt();

        while (choice != 3) {
            switch (choice) {
                case 1:
                    if (trader.health > 0) {
                        System.out.println("Куда вы хотите пойти?");
                        System.out.println("1. Купить зелье");
                        System.out.println("2. Вернуться в город");
                        int shopChoice = scanner.nextInt();
                        if (shopChoice == 1) {
                            player.buyPotion(trader);
                        } else if (shopChoice == 2) {
                            System.out.println("Куда вы хотите пойти?");
                            System.out.println("1. К торговцу");
                            System.out.println("2. В Темный лес");
                            System.out.println("3. На выход");
                            choice = scanner.nextInt();
                        }
                    } else {
                        System.out.println(" Торговец еще не вышел на работу");
                    }
                    break;
                case 2:
                    Monster enemy;
                    Random random = new Random();
                    if (random.nextInt(2) == 0) {
                        enemy = new Monster("Скелет", 50, 8, 17);
                    } else {
                        enemy = new Monster("Гоблин", 60, 10, 11);
                    }

                    while (player.health > 0 && enemy.health > 0) {
                        player.attack(enemy);
                        if (enemy.health > 0) {
                            enemy.attack(player);
                        }
                    }

                    if (player.health <= 0) {
                        System.out.println("Поражение! " + player.name + " погиб.");
                        choice = 3;
                    } else {
                        player.experience += 50;
                        player.gold += 20;
                        player.levelUp();
                        System.out.println("Ты победил " + enemy.name + "!");
                        System.out.println("Куда вы хотите пойти?");
                        System.out.println("1. К торговцу");
                        System.out.println("2. В Темный лес");
                        System.out.println("3. На выход");
                        choice = scanner.nextInt();
                    }
                    break;
                default:
                    System.out.println("Твоя цель недостижима. Выбери один из предложенных вариантов.");
                    break;
            }
        }

        System.out.println("До встречи!");
    }
}
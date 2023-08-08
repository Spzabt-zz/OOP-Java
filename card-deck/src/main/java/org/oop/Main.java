package org.oop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Please enter your age: ");
        String age = "";
        boolean ageIsNotCorrect = true;
        while (ageIsNotCorrect) {
            try {
                age = scanner.nextLine();
                Integer.parseInt(age);
                ageIsNotCorrect = false;
            } catch (NumberFormatException e) {
                System.out.println(age + ": Is not a number, try again");
            }
        }

        if (Integer.parseInt(age) < 18) {
            System.out.println("Individuals with age under 18 are not allowed to play such games.");
            System.exit(0);
        }

        Player player = new Player(name, Integer.parseInt(age));
        Deck deck = new Deck();

        boolean isOpen = true;
        while (isOpen) {
            System.out.println("Menu.");
            System.out.println("Shuffle cards, press 1");
            System.out.println("Pick a card, press 2");
            System.out.println("Print deck, press 3");
            System.out.println("Print picked cards, press 4");
            System.out.println("Exit, press 5");
            System.out.print("Enter option: ");

            int action = tryParseInt(scanner.nextLine(), 0);

            switch (action) {
                case 1 -> deck.shuffleDeck();
                case 2 -> {
                    player.pickCard(deck);
                    System.out.println("Enter S/s (stop) to stop picking the cards.");
                    String option = scanner.nextLine();
                    if (option.equalsIgnoreCase("s")) {
                        isOpen = false;
                        player.printPickedCards();
                    }
                }
                case 3 -> deck.printDeck();
                case 4 -> player.printPickedCards();
                case 5 -> isOpen = false;
                default -> System.out.println("Invalid input!");
            }
        }
    }

    public static int tryParseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
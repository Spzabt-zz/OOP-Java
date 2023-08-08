package org.oop;

import java.util.Optional;
import java.util.Stack;

public class Player {
    private final String name;
    private final int age;
    private final Stack<Card> pickedCards;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        pickedCards = new Stack<>();
    }

    public void pickCard(Deck deck) {
        Optional<Card> optionalCard = deck.getCard();
        if (optionalCard.isPresent()) {
            pickedCards.add(optionalCard.get());
        } else {
            System.out.println("Card deck is empty!");
        }
    }

    public void printPickedCards() {
        if (!pickedCards.isEmpty()) {
            for (Card card : pickedCards) {
                System.out.println("Card suit: " + card.suit() + ", Card value: " + card.value());
            }
        } else {
            System.out.println("You haven't picked a card yed");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

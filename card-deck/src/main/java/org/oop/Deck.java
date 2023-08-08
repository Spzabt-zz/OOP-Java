package org.oop;

import java.util.Optional;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private final Stack<Card> cardStack;

    public Deck() {
        cardStack = new Stack<>();
        cardStack.push(new Card(CardSuit.HEART.name(), "Ace"));
        for (int i = 2; i < 11; i++) {
            cardStack.push(new Card(CardSuit.HEART.name(), Integer.toString(i)));
        }
        cardStack.push(new Card(CardSuit.HEART.name(), "Jack"));
        cardStack.push(new Card(CardSuit.HEART.name(), "Queen"));
        cardStack.push(new Card(CardSuit.HEART.name(), "King"));

        cardStack.push(new Card(CardSuit.DIAMOND.name(), "Ace"));
        for (int i = 2; i < 11; i++) {
            cardStack.push(new Card(CardSuit.DIAMOND.name(), Integer.toString(i)));
        }
        cardStack.push(new Card(CardSuit.DIAMOND.name(), "Jack"));
        cardStack.push(new Card(CardSuit.DIAMOND.name(), "Queen"));
        cardStack.push(new Card(CardSuit.DIAMOND.name(), "King"));

        cardStack.push(new Card(CardSuit.CLUB.name(), "Ace"));
        for (int i = 2; i < 11; i++) {
            cardStack.push(new Card(CardSuit.CLUB.name(), Integer.toString(i)));
        }
        cardStack.push(new Card(CardSuit.CLUB.name(), "Jack"));
        cardStack.push(new Card(CardSuit.CLUB.name(), "Queen"));
        cardStack.push(new Card(CardSuit.CLUB.name(), "King"));

        cardStack.push(new Card(CardSuit.SPADE.name(), "Ace"));
        for (int i = 2; i < 11; i++) {
            cardStack.push(new Card(CardSuit.SPADE.name(), Integer.toString(i)));
        }
        cardStack.push(new Card(CardSuit.SPADE.name(), "Jack"));
        cardStack.push(new Card(CardSuit.SPADE.name(), "Queen"));
        cardStack.push(new Card(CardSuit.SPADE.name(), "King"));
    }

    public Optional<Card> getCard() {
        if (!cardStack.isEmpty()) {
            return Optional.of(cardStack.pop());
        }
        return Optional.empty();
    }

    public void shuffleDeck() {
        Random random = new Random();

        if (!cardStack.isEmpty()) {
            for (int i = 0; i < cardStack.size(); i++) {
                Card tempCard = cardStack.get(i);
                int randomCardPos = random.nextInt(cardStack.size() - 1);
                Card randomCard = cardStack.get(randomCardPos);
                cardStack.removeElementAt(i);
                cardStack.add(i, randomCard);
                cardStack.removeElementAt(randomCardPos);
                cardStack.add(randomCardPos, tempCard);
            }
        } else {
            System.out.println("There is nothing to shuffle!");
        }
    }

    public void printDeck() {
        if (!cardStack.isEmpty()) {
            for (Card card : cardStack) {
                System.out.println("Card suit: " + card.suit() + ", Card value: " + card.value());
            }
        } else {
            System.out.println("Card deck is empty!");
        }
    }
}

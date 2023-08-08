package src.deck;

import src.card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static Deck instance = null;
    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    private Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    private void initializeDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] colors = {"black", "red"};

        for (String color : colors) {
            for (String rank : ranks) {
                cards.add(new Card(rank, color));
                cards.add(new Card(rank, color));
            }
        }
        cards.add(new Card("Joker", "Joker"));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }


}
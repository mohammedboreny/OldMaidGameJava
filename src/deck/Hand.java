package src.deck;

import src.card.Card;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Hand {
    final private List<Card> cards;

    public Hand() {
        cards = new CopyOnWriteArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public Card getCard(int index) {
        if (isIndexValid(index)) {
            return cards.get(index);
        }
        throw new IndexOutOfBoundsException("Index is out of bounds: " + index);
    }
    private boolean isIndexValid(int index) {
        return index >= 0 && index < cards.size();
    }
}

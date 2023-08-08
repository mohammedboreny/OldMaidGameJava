package src.rules;

import src.card.Card;
import src.deck.Hand;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Rules {
    boolean isGameOver(LinkedList<Hand>players);
    
    void  takeCardFromPlayer(Hand playerHand, Hand targetPlayerHand, LinkedList<Hand>players);

    void discardMatchingPairs(Hand hand);
}

package src.players;

import src.card.Card;
import src.deck.Deck;
import src.deck.Hand;
import src.rules.OldMaidRules;
import src.rules.Rules;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlayerInitializer {
    private int numPlayers;
    private Deck deck;
    private Rules gameRules;
    public PlayerInitializer(int numPlayers) {
        this.numPlayers = numPlayers;
        deck = Deck.getInstance();
        gameRules = new OldMaidRules();
    }

    public LinkedList<Hand> initializePlayers() {
        LinkedList<Hand> players = new LinkedList<>();
        int numCardsPerPlayer = deck.getCards().size() / numPlayers;

        for (int i = 0; i < numPlayers-1; i++) {
            Hand hand = distributeCards(numCardsPerPlayer);
            gameRules.discardMatchingPairs(hand);
            players.add(hand);
        }

        Hand lastPlayerHand = distributeRemainingCards();
        gameRules.discardMatchingPairs(lastPlayerHand);
        players.add(lastPlayerHand);

        return players;
    }

    private Hand distributeCards(int numCards) {
        Hand hand = new Hand();
        for (int i = 0; i < numCards; i++) {
            Card card = deck.getCards().remove(0);
            hand.addCard(card);
        }
        return hand;
    }

    private Hand distributeRemainingCards() {
        Hand hand = new Hand();
        int remainingCards = deck.getCards().size();
        for (int i = 0; i < remainingCards; i++) {
            Card card = deck.getCards().remove(0);
            hand.addCard(card);
        }
        return hand;
    }
}

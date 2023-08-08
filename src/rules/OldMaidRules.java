package src.rules;

import src.card.Card;
import src.deck.Hand;

import java.util.*;

public class OldMaidRules implements Rules {
    @Override
    public boolean isGameOver(LinkedList<Hand> players) {
        return players.size()==1;
    }
    @Override
    public void discardMatchingPairs(Hand hand) {
        List<Card> cards = new ArrayList<>(hand.getCards());
        List<Card> matchedPairs = new ArrayList<>();

        for (int i = 0; i < cards.size() - 1; i++) {
            Card currentCard = cards.get(i);
            for (int j = i + 1; j < cards.size(); j++) {
                Card otherCard = cards.get(j);
                if (currentCard.equals(otherCard)) {
                    matchedPairs.add(currentCard);
                    matchedPairs.add(otherCard);
                    break;
                }
            }
        }
        hand.getCards().removeAll(matchedPairs);
    }


    @Override
    public  void takeCardFromPlayer(Hand playerHand, Hand targetPlayerHand, LinkedList<Hand> players) {
        if (targetPlayerHand == null || targetPlayerHand.getCards().isEmpty()) {
            return;
        }

        int randomIndex = (int) (Math.random() * targetPlayerHand.getCards().size());

        if (randomIndex >= 0 && randomIndex < targetPlayerHand.getCards().size()) {
            Card takenCard = targetPlayerHand.getCard(randomIndex);
            targetPlayerHand.removeCard(takenCard);
            playerHand.addCard(takenCard);
            discardMatchingPairs(playerHand);
            System.out.println("Current player "  + " took a card from next player "
                    + ": " + takenCard);
        } else {
            System.out.println("Invalid random index generated: " + randomIndex);
        }
    }


}

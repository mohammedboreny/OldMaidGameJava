package src.thread;

import src.deck.Hand;
import src.rules.Rules;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;

public class PlayerThread implements Runnable {
    private LinkedList<Hand> players;
    private Rules gameRules;

    public PlayerThread(LinkedList<Hand> players, Rules gameRules) {
        this.players = players;
        this.gameRules = gameRules;
    }

    @Override
    public void run() {
        while (!gameRules.isGameOver(players)) {
            Hand current;
            Hand nextPlayer;
                current = players.removeLast();
                nextPlayer = players.getLast();
            if (!current.getCards().isEmpty()) {
                    System.out.println("current player's hand: " + current.getCards());
                    System.out.println("next caards "+nextPlayer.getCards());
                    gameRules.takeCardFromPlayer(current,nextPlayer,players);
                    players.addFirst(current);
            }
            else {
                break;
            }
        }
    }
}


package src.thread;

import src.deck.Hand;
import src.players.PlayerInitializer;
import src.rules.OldMaidRules;
import src.rules.Rules;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameController {
    private int numPlayers;
    private LinkedList<Hand> players;
    private Rules gameRules;

    public GameController(int numPlayers) {
        this.numPlayers = numPlayers;
        players = new LinkedList<>();
        gameRules = new OldMaidRules();
        initializePlayers();
    }

    private void initializePlayers() {
        PlayerInitializer playerInitializer = new PlayerInitializer(numPlayers);
        players = playerInitializer.initializePlayers();
    }

    public void startGame() {
        System.out.println("=== Old Maid Game ===");
        System.out.println("Number of Players: " + numPlayers);

        BlockingQueue<Thread> activePlayerThreads = new LinkedBlockingQueue<>();
        createAndStartPlayerThreads(activePlayerThreads);
        waitForPlayerThreadsCompletion(activePlayerThreads);
        handleGameConclusion();
    }

    private void createAndStartPlayerThreads(BlockingQueue<Thread> activePlayerThreads) {
        for (int i = 0; i < players.size() ; i++) {
            Hand hand = players.get(i);
            gameRules.discardMatchingPairs(hand);
            Runnable playerThread = new PlayerThread(players, gameRules);
            activePlayerThreads.offer(new Thread(playerThread));
        }
    }

    private void waitForPlayerThreadsCompletion(BlockingQueue<Thread> activePlayerThreads) {
        for (Thread thread : activePlayerThreads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleGameConclusion() {
        if (players.size() == 1) {
            Hand hand = players.get(0);
            System.out.println(hand.getCards());
        }
    }
}

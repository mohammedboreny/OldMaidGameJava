package src;

import src.game.OldMaidGame;

import java.util.Scanner;

public class Drive {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        OldMaidGame game=new OldMaidGame(n);
        game.start();
    }
}

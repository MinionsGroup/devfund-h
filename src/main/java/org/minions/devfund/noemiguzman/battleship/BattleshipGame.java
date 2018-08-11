package org.minions.devfund.noemiguzman.battleship;

import java.util.Scanner;

/**
 * Battleship is usually a two-player game, where each player has a fleet and an ocean (hidden from the other player),
 * and tries to be the first to sink the other player’s fleet.
 * We will do just a solo version, where the computer places the ships, and the human attempts to sink them.
 *
 * We’ll play this game on a 20x20 ocean. This is larger than the ocean in the traditional battleship game.
 * In this game we will have one 8-square Battleship, one 7-square Battlecruiser, two 6-square Cruisers,
 * two 5-square Light Cruisers, three 4-square Destroyers and four 3-square Submarines.
 * Finally, unlike the traditional game, A player can shoot 5 times in each turn.
 *
 */
public class BattleshipGame {

    /**
     *  In this class you will set up the game; accept 'shots' from the user; display the results;
     *  print final scores; and ask the user if he wants to play again.
     *  All input output is done here (although some of it is done by calling a print() method in the Ocean class.)
     *  All computation will be done in the Ocean class and the various Ship classes.
     */
    public BattleshipGame() {
        System.out.println("Welcome to BattleShip Game! \n");
    }

    /**
     * main method.
     * @param args string
     */
    public static void main(final String[] args) {

        BattleshipGame  game = new BattleshipGame();
        game.payGame();
    }

    /**
     * method to play battleship game.
     */

    private void payGame() {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        Ocean ocean = new Ocean();

        ocean.placeAllShipsRandomly();

        while (true) {
            System.out.println("Shot fired: " + ocean.getShotsFired());
            System.out.println("Hits: " + ocean.getHitCount());
            System.out.println("Ships sunk: " + ocean.getShipsSunk());

            ocean.print();

            String input = scanner.nextLine();
            if (input.equals("q")) {
                System.out.println("Game over!");
                break;
            }
            String[] pairs = input.split("; ");
            for (String pair : pairs) {
                String[] locations = pair.split(", ");
                if (ocean.shootAt(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]))) {
                    System.out.println("hit");
                } else {
                    System.out.println("miss");
                }
            }

            if (ocean.isGameOver()) {
                System.out.print("Game over! Play again? y or n: ");
                input = scanner.nextLine();
                if (input.equals("y")) {
                    ocean = new Ocean();
                    ocean.placeAllShipsRandomly();
                } else {
                    System.out.println("Total shot fired: " + ocean.getShotsFired());
                    break;
                }
            }
        }
    }
}

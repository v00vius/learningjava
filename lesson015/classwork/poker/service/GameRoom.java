package service;

import entity.Card;
import entity.Player;
import utils.UserInterface;

import java.util.Arrays;

public class GameRoom {
    private Player[] players;

    public GameRoom() {
        UserInterface ui = new UserInterface();
        int numberOfPlayers = ui.getInt("The number of players: ");

        players = new Player[numberOfPlayers];
        for(int i = 0; i < players.length; ++i) {
            String name = ui.getString("Player #" + (i + 1) + ", name: ");
            players[i] = new Player(name);
            System.out.println("Player " + players[i].getName() + " has registered.");
        }
    }

    public Player[] getPlayers() {
        return players;
    }
    public void printCards(Player[] persons) {
        for (int i = 0; i < persons.length; ++i) {
            printCards(persons[i]);
        }
    }

    public void printCards(Player player) {
        System.out.println("Player " + player.getName());
        System.out.println("cards: ");
        Card[] playerCards = player.getPlayerCards();

        for (int i = 0; i < playerCards.length; ++i) {
            System.out.println(playerCards[i].toString());
        }
    }
}

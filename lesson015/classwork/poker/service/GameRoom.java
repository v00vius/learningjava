package service;

import types.Card;
import types.Player;
import utils.UserInterface;

import java.util.Arrays;

public class GameRoom {
        private Player[] players;

        public GameRoom()
        {
                UserInterface ui = new UserInterface();
                int numberOfPlayers = ui.getInt("The number of players: ");

                players = new Player[numberOfPlayers];
                for (int i = 0; i < players.length; ++i) {
                        String name = ui.getString("Player #" + (i + 1) + ", name: ");
                        players[i] = new Player(name);
                        System.out.println("Player " + players[i].getName() + " has registered.");
                }
        }

        public Player[] getPlayers()
        {
                return players;
        }

        public void printCards(Player[] persons)
        {
                for (int i = 0; i < persons.length; ++i) {
                        printCards(persons[i]);
                        println("");
                }
        }

        public void printCards(Player player)
        {
                println("Player - " + player.getName());
                Card[] playerCards = player.getPlayerCards();

                for (int i = 0; i < playerCards.length; ++i) {
                        print("  " + playerCards[i].toString());
                }

                println("");
        }

        public void println(String str)
        {
                System.out.println(str);
        }

        public void print(String str)
        {
                System.out.print(str);
        }

}

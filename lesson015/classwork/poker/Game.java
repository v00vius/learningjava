import types.Card;
import types.Cards;
import types.Player;
import service.DeckService;

public class Game {
        private Cards cards;
        private Player[] players;

        public Game()
        {
                cards = new Cards();
                DeckService service = new DeckService();

                service.fillDeck(cards.getDeck());
                cards.setDeck(service.deckShuffle(cards.getDeck()));
        }

        public void registerPlayers(Player[] playersToPlay)
        {
                players = playersToPlay;
        }

        public void dealCards()
        {
                for (int i = 0; i < players.length; i++) {
                        Card[] cardsForPlayer = new Card[5];

                        for (int j = 0; j < cardsForPlayer.length; j++) {
                                cardsForPlayer[j] = cards.dealCard();
                        }

                        Player player = players[i];
                        player.setPlayerCards(cardsForPlayer);
                }
        }

        void go()
        {
                System.out.println("Game started ...");
        }

        public Player[] getPlayers()
        {
                return players;
        }
}

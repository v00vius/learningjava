import entity.Card;
import entity.Cards;
import service.DeckService;
import service.GameRoom;

import java.util.Arrays;

public class PokerApp {
    public static void main(String[] args) {
        /*
    - подготовительные действия с колодой карт
    - создать колоду (создать массив)   -> создать экземпляр класса Cards
    - наполнить (создать необходимое количество экземпляров класса Card) -> fillDeck()
    - перемешать  -> shuffleDeck()

    - ввод количества игроков -> userInputPlayers()

    - ввести данные игроков -> createPlayer()

    - раздать карты игрокам -> dealCards()

    - вывести информацию о картах у игроков -> printPlayersInfo()

         */
/*
        Cards cards = new Cards();
        DeckService service = new DeckService();

        //System.out.println(Arrays.toString(cards.getDeck()));

        service.fillDeck(cards.getDeck());

        System.out.println(Arrays.toString(cards.getDeck()));

        Card[] deckShuffle = service.deckShuffle(cards.getDeck());

        System.out.println(Arrays.toString(deckShuffle));

        System.out.println();

        deckShuffle = service.deckShuffle(deckShuffle);

        System.out.println(Arrays.toString(deckShuffle));
*/
        Game game = new Game();
        GameRoom room = new GameRoom();

        game.registerPlayers(room.getPlayers());
        game.dealCards();
        room.printCards(game.getPlayers());

        game.go();

    }
}

package types;

public class Cards {
        /*
        создаем массив из элементов-экземпляров класса Card
        в каждой ячейке этого массива будет храниться ссылка на элемент - экземпляр класса Card
        у которого есть две переменные - value и suit
         */
        private int numberCardsDealt;
        private Card[] deck;

        public Cards()
        {
                this.numberCardsDealt = 0;
                deck = new Card[52];
        }

        public Card[] getDeck()
        {
                return deck;
        }

        public void setDeck(Card[] deck)
        {
                this.deck = deck;
        }

        public int getNumberCardsDealt()
        {
                return numberCardsDealt;
        }

        public Card dealCard()
        {
                Card card = deck[numberCardsDealt];
                ++numberCardsDealt;

                return card;
        }
}

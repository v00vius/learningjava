package entity;

public class Cards {
    /*
    создаем массив из элементов-экземпляров класса Card
    в каждой ячейке этого массива будет храниться ссылка на элемент - экземпляр класса Card
    у которого есть две переменные - value и suit
     */

    private Card[] deck = new Card[52];

    public Card[] getDeck() {
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

}

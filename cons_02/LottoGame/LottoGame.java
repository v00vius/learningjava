import javax.swing.*;
import java.util.Random;

/*
public class LottoGame {
    private int numberOfPlayers;//  10
    private int[] numbers;
    private Player[] playerList;
    private Cart[] cards;

    public void initNumbers() {
//      * подготовить "барабан" - сгенерировать массив из 90 элементов в котором случайным образом
//      будут располагаться числа от 1 до 90 (без повторений)
        numbers = new int[90];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int index1 = random.nextInt(90);
            int index2 = random.nextInt(90);

            if(index1 != index2) {
                int tmp = numbers[index1];
                numbers[index1] = numbers[index2];
                numbers[index2] = tmp;
            }
        }
    }

    public void createCards() {
//    * создать карточки 30 штук и проверить что среди них нет "дубликатов"

        cards = new Cart[30];
        for (int i = 0; i < ; i++) {
            
        }
    }

    public void registerPlayers() {https://github.com/v00vius/learningjava/tree/master/cons_02/LottoGame
        UserInput ui = new UserInput();

        numberOfPlayers = ui.getInt("Number of players: ");
        playerList = new Player[numberOfPlayers];

//
        for (int i = 0; i < playerList.length; i++) {
//
            String nickname =  ui.getString("Enter your nickname, please:");
            int age = ui.getInt("Your age: ");

//доработать исключения
            if(!registerPlayer(i, nickname, age)) {
                System.out.println("You are too young to play this game!");
                continue;
            }
        }
    }
    public boolean registerPlayer(int i, String nickname, int age) {
        Player player = new Player(nickname, age);
        playerList[i] = player;
    }


    public static void main(String[] args) {

//        player1 = new Player();
//        player1 = new Player();
//        player1 = new Player();
//        player1 = new Player();
    }
}
*/
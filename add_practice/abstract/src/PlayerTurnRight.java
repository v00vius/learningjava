public class PlayerTurnRight extends Player{

    @Override
    public void move() {
        println("PlayerTurnRight: move");
        super.turnRight();
    }

}

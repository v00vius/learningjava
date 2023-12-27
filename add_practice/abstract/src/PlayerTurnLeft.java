public class PlayerTurnLeft extends Player {
    @Override
    public void move() {
        println("PlayerTurnLeft: move");
        super.turnLeft();
    }
}

public class App {
        public static void main(String[] args) throws Exception
        {
                MovementSystem system = new MovementSystem(
                        new Movement[]{
                                new Player(),
                                new PlayerSlowDown(),
                                new PlayerTurnLeft(),
                                new PlayerTurnRight()
                        }
                );

                system.handleMovement(Event.evAccelerate);
                system.handleMovement(Event.evSlowDown);
                system.handleMovement(Event.evTurnLeft);
                system.handleMovement(Event.evTurnRight);
        }
}

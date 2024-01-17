public class MovementSystem {
        private Movement[] movements;

        public MovementSystem(Movement[] movements)
        {
                this.movements = movements;
        }

        public void handleMovement(Event ev)
        {
                Player player = (Player) movements[ev.code];

                player.move();
        }
}

public class PlayerSlowDown extends Player {
        @Override
        public void move()
        {
                println("PlayerSlowDown move:");
                super.slowDown();
        }
}

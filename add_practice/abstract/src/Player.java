public class Player implements Movement {
        @Override
        public void move()
        {
                println("Player move:");
                accelerate();
        }

        @Override
        public void accelerate()
        {
                println("Unimplemented method 'accelerate'");
        }

        @Override
        public void slowDown()
        {
                println("Unimplemented method 'slowDown'");
        }

        @Override
        public void turnLeft()
        {
                println("Unimplemented method 'turnLeft'");
        }

        @Override
        public void turnRight()
        {
                println("Unimplemented method 'turnRight'");
        }

        public void println(String s)
        {
                System.out.println(s);
        }

}

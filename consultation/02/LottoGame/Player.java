public class Player {
        private String nickname;
        private int age;
        private Cart[] carts;

        public Player(String nickname, int age)
        {
                this.nickname = nickname;
                this.age = age;
        }

        public void setNickname(String nickname)
        {
                this.nickname = nickname;
        }

        public void setAge(int age)
        {
                this.age = age;
        }
}

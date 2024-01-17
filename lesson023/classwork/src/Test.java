public class Test {
        short[] sData = new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        public void exec()
        {
                for (short i = 0, j = (short) (sData.length - 1); i < sData.length; ++i, --j) {
                        sData[i] = (short) (sData[j] + sData[i]);
                }
        }

        public static void main(String[] args)
        {
        }
}

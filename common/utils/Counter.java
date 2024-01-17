package utils;

public class Counter {
        private int insertionCount;
        private int removalCount;

        public Counter()
        {
                insertionCount = 0;
                removalCount = 0;
        }

        public void incrementInsertionCount()
        {
                insertionCount++;
        }

        public void incrementRemovalCount()
        {
                removalCount++;
        }

        public int getCounts()
        {
                return insertionCount - removalCount;
        }

        public boolean isEmpty()
        {
                return getCounts() == 0;
        }

        public int getInsertions()
        {
                return insertionCount;
        }

        public int getRemovals()
        {
                return removalCount;
        }
}

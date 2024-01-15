package comparetors;

public class Bag {
        private int material;
        private int size;
        private int color;

        public Bag(int material, int size, int color)
        {
                this.material = material;
                this.size = size;
                this.color = color;
        }

        public int getMaterial()
        {
                return material;
        }

        public int getSize()
        {
                return size;
        }

        public int getColor()
        {
                return color;
        }

        @Override
        public String toString()
        {
                return "comparetors.Bag{" +
                        "material=" + material +
                        ", size=" + size +
                        ", color=" + color +
                        "}\n";
        }
}

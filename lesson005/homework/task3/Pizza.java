package task3;

import utils.*;

public class Pizza {
        private static int caloriesInCm2 = 40;
        private String name;
        private int size;

        public Pizza(String name, int size)
        {
                this.name = name;
                this.size = size;
        }

        public int getCalories()
        {
                return (int) (caloriesInCm2 * Utils.circleArea((double) getSize()));
        }

        public String getName()
        {
                return name;
        }

        public int getSize()
        {
                return size;
        }

        public String toString()
        {
                return "\"" + getName() + "\", " + getSize() + " cm, " + getCalories() + " calories";
        }

        public static void main(String[] args)
        {
                Pizza pizza1 = new Pizza("Cheese Pizza", 24);
                Pizza pizza2 = new Pizza("Pepperoni Pizza", 28);

                System.out.println(pizza1.toString());
                System.out.println(pizza2.toString());

                int caloriesDifference = pizza2.getCalories() - pizza1.getCalories();

                System.out.println("The difference, calories: " + caloriesDifference);
        }
}

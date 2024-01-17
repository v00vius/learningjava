package boxes;

import java.util.Random;

public class App {
public static void main(String[] args)
{
        Random rnd = new Random(System.currentTimeMillis());
        BoxManager boxManager = new BoxManager();

        for (int i = 0; i < 10; ++i) {
                HeavyBox box = boxManager.createBox(String.format("Tag%02d", rnd.nextInt(0, 4)));
                float length = rnd.nextFloat(0.1f, 1f);
                float width = rnd.nextFloat(0.1f, 1f);
                float height = rnd.nextFloat(0.1f, 1f);
                float mass = rnd.nextFloat(0.1f, 10f);


                box.setData(length, width, height, mass);
        }

        System.out.println(boxManager.getBoxes());
        System.out.println("++++++++++++++++++++++");
        System.out.println(boxManager.getTaggedAs("Tag02"));
}
}

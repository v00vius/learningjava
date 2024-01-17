package boxes;

public class HeavyBox {
private int id;
private float length;
private float width;
private float height;
private float mass;
private String tag;

public HeavyBox(int id, String owner)
{
        this.id = id;
        this.tag = owner;
}
public HeavyBox setData(float length, float width, float height, float mass)
{
        this.length = length;
        this.width = width;
        this.height = height;
        this.mass = mass;

        return this;
}

public float getVolume()
{
        return length * width * height;
}

public float getMass()
{
        return mass;
}

public String getTag()
{
        return tag;
}

@Override
public String toString()
{
        return "HeavyBox{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", mass=" + mass +
                ", tag='" + tag + '\'' +
                "}\n";
}
}

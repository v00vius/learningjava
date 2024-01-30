public class Vec2 {
private float x;
private float y;

public Vec2(float x, float y)
{
        this.x = x;
        this.y = y;
}

public float x()
{
        return x;
}

public void setX(float x)
{
        this.x = x;
}

public float y()
{
        return y;
}

public void setY(float y)
{
        this.y = y;
}

@Override
public String toString()
{
        return "(" + x + ',' + y + ")";
}
}

import java.util.Optional;

public class Vec2 {
static public final float EPSILON = 1e-4f;
private float x;
private float y;

static public Optional<Float> linearFunction(Vec2 p1, Vec2 p2, float x)
{
        float dy = p2.y - p1.y;
        float dx = p2.x - p1.x;

        if(Math.abs(dx) < EPSILON)
                return Optional.empty();

        float a = dy / dx;

        return Optional.of(a * x + p1.y);
}

public Vec2(float x, float y)
{
        this.x = x;
        this.y = y;
}
public Vec2()
{
        this.x = 0.f;
        this.y = 0.f;
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

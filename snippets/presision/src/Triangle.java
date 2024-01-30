public class Triangle {
private Vec2 p0;
private Vec2 p1;
private Vec2 p2;

public Triangle(Vec2 p0, Vec2 p1, Vec2 p2)
{
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
}
public Vec2 getP0()
{
        return p0;
}

public void setP0(Vec2 p0)
{
        this.p0 = p0;
}

public Vec2 getP1()
{
        return p1;
}

public void setP1(Vec2 p1)
{
        this.p1 = p1;
}

public Vec2 getP2()
{
        return p2;
}

public void setP2(Vec2 p2)
{
        this.p2 = p2;
}

@Override
public String toString()
{
        return "{" + p0 + p1 + p2 + '}';
}
}

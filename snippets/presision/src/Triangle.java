import java.util.Optional;

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

public void counterClock()
{
        if(p1.x() < p0.x()) {
                Vec2 tmp = p1;

                p1 = p0;
                p0 = tmp;

                System.out.print(" min: 0<->1");
        }

        if(p2.x() < p0.x()) {
                Vec2 tmp = p2;

                p2 = p0;
                p0 = tmp;

                System.out.print(" min: 2<->0");
        }

        if(p1.x() > p2.x()) {
                Vec2 tmp = p1;

                p1 = p2;
                p2 = tmp;

                System.out.print(" max: 1<->2");
        }

        Optional<Float> y = Vec2.linearFunction(p0, p2, p1.x());

        if(y.isEmpty())
                return;

        if(p1.y() > y.get()) {
                Vec2 tmp = p1;

                p1 = p2;
                p2 = tmp;

                System.out.print(" cclock: 1<->2");
        }

        System.out.print("\n");
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

import java.util.Random;

public class RayTracer {
static public final int RESOLUTION = 512;
private Vec2 position;
private Vec2 direction;
private Bits area;
private int width;
private int height;
private float cellSize;
private float fov;
private float[] raster;
static private Random rnd = new Random(System.currentTimeMillis());

public RayTracer(int width, int height)
{
        position = new Vec2();
        direction = new Vec2();
        cellSize = 16.f;
        this.width = width;
        this.height = height;

        area = new Bits(width, height);
        makeBorder();

        raster = new float[RESOLUTION];
}

private void makeBorder()
{
        area.clear();

        for (int x = 0; x < width; ++x) {
                area.set(x, 0);
                area.set(x, height - 1);
        }

        for (int y = 0; y < height; ++y) {
                area.set(0, y);
                area.set(width - 1, y);
        }
}

public void makeObstacles(int n)
{
        area.clear();
        makeBorder();

        for (int i = 0; i < n; ++i) {
                int x = rnd.nextInt(0, width);
                int y = rnd.nextInt(0, height);

                area.set(x, y);
        }
}

public void setFov(float fovDegrees)
{
        fov = (float) Math.toRadians(fovDegrees);
}

public void setCellSize(float cellSize)
{
        this.cellSize = cellSize;
}

public void setPosition(float x, float y)
{
        position.setX(x);
        position.setY(y);
}

public void setDirection(float x, float y)
{
        direction.setX(x);
        direction.setY(y);
}

public float getWidth()
{
        return (float) width;
}

public float getHeight()
{
        return (float) height;
}

public void trace()
{
        double length = Math.sqrt(direction.x() * direction.x() + direction.y() * direction.y());
        float angle0 = (float) Math.acos(direction.x() / length);
        float angle = angle0 - 0.5f * fov;
        float angle_end = angle + fov;
        float angle_step = (angle_end - angle) / (float)RESOLUTION;

        for(int i = 0; i < RESOLUTION; ++i, angle += angle_step) {
                float distance = trace(angle);

                raster[i] = distance;
        }
}
private float trace(float angle)
{
//        float step = 0.5f * cellSize;
        float step = 0.5f;
        float step_x = step * (float) Math.cos(angle);
        float step_y = step * (float) Math.sin(angle);
        float x = position.x();
        float y = position.y();

        for (;;) {
//                int area_x = (int) (x / cellSize);
//                int area_y = (int) (y / cellSize);

                int area_x = (int)x;
                int area_y = (int)y;

                if (area.get(area_x, area_y)) {
                        float dx = x - position.x();
                        float dy = y - position.y();

                        return (float) Math.sqrt(dx * dx + dy * dy);
                }

                x += step_x;
                y += step_y;
        }

//        return 0.f;
}
public void printRaster()
{
        for (int i = 0; i < RESOLUTION; ++i) {
                System.out.println(i + ") " + raster[i]);
        }
}

public static void main(String[] args)
{
        RayTracer test = new RayTracer(1366, 768);

        test.setCellSize(1.f);
        test.setPosition(0.5f * test.getWidth(), 0.5f * test.getHeight());
        test.setDirection(2.f, 0.f);
        test.setFov(60.f);

        int loops = 11;
        float avg_fps = 0.f;

        for (int i = 0; i < loops; ++i) {
                test.makeObstacles((int)(test.getHeight() + test.getWidth()));

                final int n = 1_000;
                long delta = System.currentTimeMillis();

                for (int j = 0; j < n; ++j)
                        test.trace();

                delta = System.currentTimeMillis() - delta;
                float fps = 1000.f * (float)n / (float)delta;
                avg_fps += fps;
                System.out.println("delta = " + delta + " ms, fps = " + fps);
        }

        test.printRaster();
        System.out.println("Ray tracer: " + test.getWidth() + " x " + test.getHeight() + " pix, 1 Core, avg fps = " + avg_fps / (float)loops);
}
}

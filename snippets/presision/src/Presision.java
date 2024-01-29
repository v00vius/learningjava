public class Presision  {
private float epsilon;

public Presision(float epsilon)
{
        this.epsilon = epsilon;
}
public int compare(float v1, float v2)
{
        float difference = Math.abs(v2 - v1);

        if(difference <= epsilon)
                return 0;

        return v1 < v2 ? -1 : +1;
}
}

package entity;

public abstract class Entity {
static private int idCounter = 0;
static public int newId()
{
        return ++idCounter;
}
private final int id;

public Entity(int id)
{
        this.id = id;
}

public int getId()
{
        return id;
}

public abstract String getText();
@Override
public String toString()
{
        return "id=" + id;
}
}

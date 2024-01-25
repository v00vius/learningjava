package entity;

public class Entity {
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
}

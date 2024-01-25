package ui;

public abstract class MenuItem {
private String name;
private boolean enabled;

public boolean isExit()
{
        return false;
}

public MenuItem(String name)
{
        this.name = name;
        this.enabled = true;
}

public boolean isEnabled()
{
        return enabled;
}

public void setEnabled(boolean enabled)
{
        this.enabled = enabled;
}

public void exec()
{
        if(enabled)
                command();
}
protected abstract void command();
}

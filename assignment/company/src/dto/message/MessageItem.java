package dto.message;

public  class MessageItem {
private final int subsystem;
private final int severity;
private final String message;

public MessageItem(int subsystem, int severity, String message)
{
        this.subsystem = subsystem;
        this.severity = severity;
        this.message = message;
}

public int getSubsystem()
{
        return subsystem;
}

public int getSeverity()
{
        return severity;
}

public String getMessage()
{
        return message;
}

@Override
public String toString()
{
        return "MessageItem{" +
               "subsystem=" + subsystem +
               ", severity=" + severity +
               ", message='" + message + '\'' +
               '}';
}
}

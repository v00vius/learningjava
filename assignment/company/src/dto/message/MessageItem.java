package dto.message;

public  class MessageItem {
private final Subsystem subsystem;
private final Severity severity;
private final String message;

public MessageItem(Subsystem subsystem, Severity severity, String message)
{
        this.subsystem = subsystem;
        this.severity = severity;
        this.message = message;
}

public Subsystem getSubsystem()
{
        return subsystem;
}

public Severity getSeverity()
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

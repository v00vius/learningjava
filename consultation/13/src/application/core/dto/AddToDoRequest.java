package application.core.dto;

public class AddToDoRequest {
    private Integer id;
    private String name;
    private String description;

    public AddToDoRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

public AddToDoRequest(Integer id)
{
    this.id = id;
}

public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

public Integer getId()
{
    return id;
}
}

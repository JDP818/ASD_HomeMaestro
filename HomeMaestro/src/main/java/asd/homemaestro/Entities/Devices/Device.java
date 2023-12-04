package asd.homemaestro.Entities.Devices;

public abstract class Device implements IDevice
{
    private String Id;
    private String Name;
    private String State;

    public Device() {
    }

    public Device(String id, String name, String state)
    {
        this.Id = id;
        this.Name = name;
        this.State = state;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
package asd.homemaestro.Entities.Devices;

public abstract class Device implements IDevice
{
    private String Id;
    private String Name;
    private String State;

    public Device(String Id, String Name, String State)
    {
        this.Id = Id;
        this.Name = Name;
        this.State = State;
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


    @Override
    public void turnOn(){
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnOff(){
        throw new UnsupportedOperationException();
    }

    @Override
    public void getInfo(){
        throw new UnsupportedOperationException();
    }
}
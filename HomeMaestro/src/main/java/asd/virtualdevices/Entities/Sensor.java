package asd.virtualdevices.Entities;

public abstract class Sensor
{
    private String Id;

    public Sensor(){

    }

    public Sensor(String Id)
    {
        this.Id = Id;
    }

    // Setter
    public void setId(String Id) {
        this.Id = Id;
    }

    public String getId() {
        return this.Id;
    }

    public abstract String CreateReading();
    public abstract String toString();
}

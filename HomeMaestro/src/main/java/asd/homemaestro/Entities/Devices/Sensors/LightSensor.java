package asd.homemaestro.Entities.Devices.Sensors;

public class LightSensor extends Sensor {


    public LightSensor(String id, String name, String State) {
        super(id, name, State);
    }

    @Override
    public void CreateReading() {
        throw new UnsupportedOperationException();
    }
}
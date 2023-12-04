package asd.homemaestro.Entities.Devices.Sensors;

import asd.homemaestro.Entities.Triggers.Trigger;

import java.util.List;

public class LightSensor extends Sensor {


    public LightSensor(String id, String name, String State, List<Trigger> triggerList) {
        super(id, name, State, triggerList);
    }

    @Override
    public void CreateReading() {
        throw new UnsupportedOperationException();
    }
}
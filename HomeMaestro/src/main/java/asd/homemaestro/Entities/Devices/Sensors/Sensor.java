package asd.homemaestro.Entities.Devices.Sensors;

import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Triggers.Trigger;

import java.util.List;

public abstract class Sensor extends Device
{
    private List<Trigger> triggerList;

    public Sensor() {
    }

    public Sensor(String id, String name, String State, List<Trigger> triggerList) {

        super(id, name, State);
        this.triggerList = triggerList;
    }

    public List<Trigger> getTriggerList() {
        return triggerList;
    }

    public void setTriggerList(List<Trigger> triggerList) {
        this.triggerList = triggerList;
    }

    public abstract void CreateReading();
}
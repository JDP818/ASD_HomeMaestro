package asd.homemaestro.Entities.Devices.Actuators;

import asd.homemaestro.Entities.Devices.Device;
import asd.virtualdevices.Entities.Sensor;

public abstract class Actuator extends Device
{
    public Actuator(String Id, String Name, String State) {
        super(Id, Name, State);
    }
}

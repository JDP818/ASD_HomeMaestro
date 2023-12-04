package asd.homemaestro.Entities.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Triggers.Trigger;

import java.util.List;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor() {
    }

    public TemperatureSensor(String id, String name, String State, List<Trigger> triggerList) {
        super(id, name, State, triggerList);
    }

    @Override
    public void CreateReading() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getState() {
        try{
            Integer.parseInt(super.getState());
            return super.getState() + " " + Consts.MEASUREMENT_TEMPERATURE_C;
        }catch (Exception e){
            return Consts.STATE_OFF;
        }
    }
}

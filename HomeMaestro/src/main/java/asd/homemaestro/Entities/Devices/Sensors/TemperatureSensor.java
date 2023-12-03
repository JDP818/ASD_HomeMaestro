package asd.homemaestro.Entities.Devices.Sensors;

import asd.Utils.Consts;

public class TemperatureSensor extends Sensor {


    public TemperatureSensor(String id, String name, String State) {
        super(id, name, State);
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

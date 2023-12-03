package asd.homemaestro.Entities.Devices.Actuators;

import asd.Utils.Consts;

public class AcActuator extends Actuator{

    public AcActuator(String Id, String Name, String State) {
        super(Id, Name, State);
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

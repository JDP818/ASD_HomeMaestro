package asd.homemaestro.Entities.Triggers;

import asd.Utils.Consts;

public class AcTrigger2 extends Trigger{

    public AcTrigger2(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType) {
        super(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }

    @Override
    public String getActuatorState(String readingReceived) {
        String state = Consts.STATE_OFF;
        try{
            if(super.getTriggerType() == TriggerType.Higher){
                if(Integer.parseInt(super.getSensorState()) > Integer.parseInt(readingReceived)){
                    state = super.getActuatorState();
                };
            } else if (super.getTriggerType() == TriggerType.Lower) {
                if(Integer.parseInt(super.getSensorState()) < Integer.parseInt(readingReceived)){
                    state = super.getActuatorState();
                };
            } else if (super.getTriggerType() == TriggerType.Equal) {
                if(Integer.parseInt(super.getSensorState()) == Integer.parseInt(readingReceived)){
                    state = super.getActuatorState();
                };
            }
        }catch (Exception e){
        }
        return state;
    }
}

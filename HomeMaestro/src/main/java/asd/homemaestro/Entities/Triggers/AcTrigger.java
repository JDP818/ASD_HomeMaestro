package asd.homemaestro.Entities.Triggers;

import asd.Utils.Consts;

public class AcTrigger extends Trigger{

    public AcTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, String triggerType) {
        super(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }

    @Override
    public String getTriggerState(String readingReceived) {
        String state = Consts.NO_TRIGGER;
        try{
            if(super.getTriggerType() == TriggerType.Higher.name()){
                if(Integer.parseInt(super.getSensorState()) <= Integer.parseInt(readingReceived)){
                    state = super.getActuatorState();
                };
            } else if (super.getTriggerType() == TriggerType.Lower.name()) {
                if(Integer.parseInt(super.getSensorState()) >= Integer.parseInt(readingReceived)){
                    state = super.getActuatorState();
                };
            }
        }catch (Exception e){
        }
        return state;
    }
}

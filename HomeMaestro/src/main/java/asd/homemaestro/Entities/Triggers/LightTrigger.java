package asd.homemaestro.Entities.Triggers;

import asd.Utils.Consts;

public abstract class LightTrigger extends Trigger {

    public LightTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, String triggerType) {
        super(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }

    @Override
    public String getTriggerState(String readingReceived) {
        String state = Consts.STATE_OFF;
        try {
            int lightIntensity = Integer.parseInt(readingReceived);
            TriggerType triggerType = TriggerType.valueOf(super.getTriggerType());


            if (triggerType == TriggerType.Higher) {
                if (lightIntensity > Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            } else if (triggerType == TriggerType.Lower) {
                if (lightIntensity < Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            } else if (triggerType == TriggerType.EQUAL) {
                if (lightIntensity == Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            }
        } catch (Exception e) {
        }
        return state;
    }
}

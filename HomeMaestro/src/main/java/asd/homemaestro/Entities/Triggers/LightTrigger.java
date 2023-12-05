package asd.homemaestro.Entities.Triggers;

import asd.Utils.Consts;

public class LightTrigger extends Trigger {

    public LightTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType) {
        super(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }

    @Override
    public String getActuatorState(String readingReceived) {
        String state = Consts.STATE_OFF;
        try {
            int lightIntensity = Integer.parseInt(readingReceived);

            if (super.getTriggerType() == TriggerType.Higher) {
                if (lightIntensity > Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            } else if (super.getTriggerType() == TriggerType.Lower) {
                if (lightIntensity < Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            } else if (super.getTriggerType() == TriggerType.Equal) {
                if (lightIntensity == Integer.parseInt(super.getSensorState())) {
                    state = super.getActuatorState();
                }
            }
        } catch (Exception e) {
        }
        return state;
    }
}

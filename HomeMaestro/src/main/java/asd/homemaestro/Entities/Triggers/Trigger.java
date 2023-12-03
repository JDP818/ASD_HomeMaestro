package asd.homemaestro.Entities.Triggers;

import asd.Utils.Consts;
import asd.Utils.SensorType;

public abstract class Trigger {

    private String sensorId;
    private String actuatorId;
    private String sensorState;
    private String actuatorState;
    private TriggerType triggerType;

    public Trigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType) {
        this.sensorId = sensorId;
        this.actuatorId = actuatorId;
        this.sensorState = sensorState;
        this.actuatorState = actuatorState;
        this.triggerType = triggerType;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getActuatorId() {
        return actuatorId;
    }

    public void setActuatorId(String actuatorId) {
        this.actuatorId = actuatorId;
    }

    public String getSensorState() {
        return sensorState;
    }

    public void setSensorState(String sensorState) {
        this.sensorState = sensorState;
    }

    public String getActuatorState() {
        return actuatorState;
    }

    public void setActuatorState(String actuatorState) {
        this.actuatorState = actuatorState;
    }

    public TriggerType getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(TriggerType triggerType) {
        this.triggerType = triggerType;
    }


    public String isTriggered(String readingReceived){
        return getActuatorState(readingReceived);
    }

    public abstract String getActuatorState(String readingReceived);
}

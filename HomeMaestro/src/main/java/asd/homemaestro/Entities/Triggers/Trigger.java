package asd.homemaestro.Entities.Triggers;

public abstract class Trigger {

    private String SensorId;
    private String ActuatorId;
    private String SensorState;
    private String ActuatorState;
    private TriggerType TriggerType;

    public Trigger(String sensorId, String actuatorId, String sensorState, String actuatorState, String triggerType) {
        this.SensorId = sensorId;
        this.ActuatorId = actuatorId;
        this.SensorState = sensorState;
        this.ActuatorState = actuatorState;
        this.TriggerType = TriggerType.valueOf(triggerType);
    }

    public String getSensorId() {
        return SensorId;
    }

    public void setSensorId(String sensorId) {
        SensorId = sensorId;
    }

    public String getActuatorId() {
        return ActuatorId;
    }

    public void setActuatorId(String actuatorId) {
        ActuatorId = actuatorId;
    }

    public String getSensorState() {
        return SensorState;
    }

    public void setSensorState(String sensorState) {
        SensorState = sensorState;
    }

    public String getActuatorState() {
        return ActuatorState;
    }

    public void setActuatorState(String actuatorState) {
        ActuatorState = actuatorState;
    }

    public String getTriggerType() {
        return TriggerType.toString();
    }

    public void setTriggerType(String triggerType) {
        TriggerType = TriggerType.valueOf(triggerType);
    }

    public abstract String getTriggerState(String readingReceived);

}

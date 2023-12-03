package asd.homemaestro.Services.Triggers;

import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;
import org.json.JSONObject;

public interface ITriggerFactory {
    Trigger createTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType);
    Trigger createTriggerFromJson(JSONObject jsonObject);
}

package asd.homemaestro.Services.Triggers;

import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public interface ITriggerFactory {
    Trigger createTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType);
    List<Trigger> createTriggerListFromJson(JSONArray jsonArray, String deviceId);
}

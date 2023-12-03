package asd.homemaestro.Services.Triggers;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Triggers.ACTrigger;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;
import com.google.gson.Gson;
import org.json.JSONObject;

public class ACTriggerFactory implements ITriggerFactory {
    @Override
    public Trigger createTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType) {
        return new ACTrigger(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }
    @Override
    public Trigger createTriggerFromJson(JSONObject jsonObject) {
        ACTrigger acTrigger = null;
        Gson gson = new Gson();
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(ACTrigger.class.getSimpleName())){
            acTrigger = gson.fromJson(jsonObject.toString(), ACTrigger.class);
        }
        return acTrigger;
    }
}

package asd.homemaestro.Services.Triggers;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Entities.Triggers.AcTrigger;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TriggerFactory implements ITriggerFactory {
    private AcTriggerFactory acTriggerFactory;

    public TriggerFactory() {
        this.acTriggerFactory = new AcTriggerFactory();
    }

    @Override
    public Trigger createTrigger(String sensorId, String actuatorId, String sensorState, String actuatorState, TriggerType triggerType) {
        return new AcTrigger(sensorId, actuatorId, sensorState, actuatorState, triggerType);
    }

    @Override
    public List<Trigger> createTriggerListFromJson(JSONArray jsonArray, String deviceId) {
        List<Trigger> triggers = new ArrayList<>();
        for(int i = 0; i < jsonArray.length(); i++){
            var jsonObject = jsonArray.getJSONObject(i);
            Trigger trigger = null;
            if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(AcTrigger.class.getSimpleName())
                && jsonObject.get(Consts.JSONSENSORID).toString().equalsIgnoreCase(deviceId)){
                trigger = acTriggerFactory.CreateAcTrigger(jsonObject);
            }
            if (trigger != null){
                triggers.add(trigger);
            }
        }
        return triggers;
    }
}

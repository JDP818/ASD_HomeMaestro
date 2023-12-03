package asd.homemaestro.DataAccess.Triggers;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Triggers.ACTrigger;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Services.Triggers.ACTriggerFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TriggerRepository {
    public List<Trigger> getTriggersForSensor(String sensorId){
        List<Trigger> triggerList = new ArrayList<>();
        JSONArray triggersJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        for(int i = 0; i < triggersJson.length(); i++){
            var jsonObject = triggersJson.getJSONObject(i);
            if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(ACTrigger.class.getSimpleName())
                    && jsonObject.get(Consts.JSONROOMID).toString().equalsIgnoreCase(sensorId)) {
                Trigger acTrigger = getACTrigger(jsonObject);
                if(acTrigger != null)
                    triggerList.add(acTrigger);
            }
        }
        return triggerList;
    }

    private Trigger getACTrigger(JSONObject jsonObject){
        Trigger trigger = null;
        ACTriggerFactory acTriggerFactory = new ACTriggerFactory();
        Trigger acTrigger = acTriggerFactory.createTriggerFromJson(jsonObject);
        if(acTrigger != null)
            trigger = acTrigger;
        return trigger;
    }
}

package asd.homemaestro.DataAccess.Triggers;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Services.Triggers.TriggerFactory;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class TriggerRepository {
    private TriggerFactory triggerFactory;

    public TriggerRepository() {
        this.triggerFactory = new TriggerFactory();
    }

    public List<Trigger> GetTriggersForSensor(String sensorId){
        JSONArray triggersJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return triggerFactory.createTriggerListFromJson(triggersJson, sensorId);
    }
}

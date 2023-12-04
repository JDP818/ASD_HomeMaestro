package asd.homemaestro.Services.Triggers;

import asd.homemaestro.Entities.Triggers.AcTrigger2;
import com.google.gson.Gson;
import org.json.JSONObject;

public class AcTriggerFactory {
    public AcTrigger2 CreateAcTrigger(JSONObject jsonObject){
        AcTrigger2 acTrigger = null;
        Gson gson = new Gson();
        acTrigger = gson.fromJson(jsonObject.toString(), AcTrigger2.class);
        return  acTrigger;
    }
}
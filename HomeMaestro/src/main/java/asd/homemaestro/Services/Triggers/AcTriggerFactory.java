package asd.homemaestro.Services.Triggers;

import asd.homemaestro.Entities.Triggers.AcTrigger;
import com.google.gson.Gson;
import org.json.JSONObject;

public class AcTriggerFactory {
    public AcTrigger CreateAcTrigger(JSONObject jsonObject){
        AcTrigger acTrigger = null;
        Gson gson = new Gson();
        acTrigger = gson.fromJson(jsonObject.toString(), AcTrigger.class);
        return  acTrigger;
    }
}
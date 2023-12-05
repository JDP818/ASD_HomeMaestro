package asd.homemaestro.Services.Triggers;

import asd.homemaestro.Entities.Triggers.LightTrigger;
import com.google.gson.Gson;
import org.json.JSONObject;

public class LightTriggerFactory {
    public LightTrigger CreateLightTrigger(JSONObject jsonObject) {
        LightTrigger lightTrigger = null;
        Gson gson = new Gson();
        lightTrigger = gson.fromJson(jsonObject.toString(), LightTrigger.class);
        return lightTrigger;
    }
}

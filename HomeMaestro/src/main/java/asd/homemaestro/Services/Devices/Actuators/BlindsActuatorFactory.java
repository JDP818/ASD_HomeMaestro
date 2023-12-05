package asd.homemaestro.Services.Devices.Actuators;

import asd.homemaestro.Entities.Devices.Actuators.Blinds;
import com.google.gson.Gson;
import org.json.JSONObject;

public class BlindsActuatorFactory {
    public Blinds CreateBlindsActuator(JSONObject jsonObject){
        Blinds blinds = null;
        Gson gson = new Gson();
        blinds = gson.fromJson(jsonObject.toString(), Blinds.class);
        return  blinds;
    }
}

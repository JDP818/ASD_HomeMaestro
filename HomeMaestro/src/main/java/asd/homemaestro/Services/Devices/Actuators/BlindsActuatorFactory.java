package asd.homemaestro.Services.Devices.Actuators;

import asd.homemaestro.Entities.Devices.Actuators.BlindsActuator;
import com.google.gson.Gson;
import org.json.JSONObject;

public class BlindsActuatorFactory {
    public BlindsActuator CreateBlindsActuator(JSONObject jsonObject){
        BlindsActuator blindsActuator = null;
        Gson gson = new Gson();
        blindsActuator = gson.fromJson(jsonObject.toString(), BlindsActuator.class);
        return blindsActuator;
    }
}

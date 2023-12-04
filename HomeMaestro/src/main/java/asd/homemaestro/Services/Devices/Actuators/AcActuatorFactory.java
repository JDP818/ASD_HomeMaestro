package asd.homemaestro.Services.Devices.Actuators;

import asd.homemaestro.Entities.Devices.Actuators.AcActuator;
import com.google.gson.Gson;
import org.json.JSONObject;

public class AcActuatorFactory {
    public AcActuator CreateAcActuator(JSONObject jsonObject){
        AcActuator acActuator = null;
        Gson gson = new Gson();
        acActuator = gson.fromJson(jsonObject.toString(), AcActuator.class);
        return  acActuator;
    }
}

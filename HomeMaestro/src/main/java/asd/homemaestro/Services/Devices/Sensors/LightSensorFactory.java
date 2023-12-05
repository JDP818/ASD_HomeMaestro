package asd.homemaestro.Services.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Sensors.LightSensor;
import com.google.gson.Gson;
import org.json.JSONObject;

public class LightSensorFactory {
    public LightSensor CreateLightSensor(JSONObject jsonObject) {
        LightSensor lightSensor = null;
        Gson gson = new Gson();
        lightSensor = gson.fromJson(jsonObject.toString(), LightSensor.class);
        return lightSensor;
    }
}

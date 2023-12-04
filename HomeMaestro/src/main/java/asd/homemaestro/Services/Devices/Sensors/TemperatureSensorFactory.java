package asd.homemaestro.Services.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Devices.Sensors.TemperatureSensor;
import com.google.gson.Gson;
import org.json.JSONObject;

public class TemperatureSensorFactory{
    public TemperatureSensor CreateTemperatureSensor(JSONObject jsonObject){
        TemperatureSensor temperatureSensor = null;
        Gson gson = new Gson();
        temperatureSensor = gson.fromJson(jsonObject.toString(), TemperatureSensor.class);
        return  temperatureSensor;
    }
}

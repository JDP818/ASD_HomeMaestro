package asd.homemaestro.Services.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Devices.Sensors.TemperatureSensor;
import com.google.gson.Gson;
import org.json.JSONObject;

public class SensorFactory implements ISensorFactory{
    @Override
    public Sensor createSensorFromJson(JSONObject jsonObject) {
        Sensor sensor = null;
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(TemperatureSensor.class.getSimpleName())){
            TemperatureSensorFactory temperatureSensorFactory = new TemperatureSensorFactory();
            sensor = temperatureSensorFactory.CreateTemperatureSensor(jsonObject);
        }
        return sensor;
    }
}

package asd.homemaestro.Services.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Devices.Sensors.TemperatureSensor;
import asd.homemaestro.Entities.Devices.Sensors.LightSensor;
import com.google.gson.Gson;
import org.json.JSONObject;

public class SensorFactory implements ISensorFactory {
    @Override
    public Sensor createSensorFromJson(JSONObject jsonObject) {
        Sensor sensor = null;
        String sensorType = jsonObject.get(Consts.JSONTYPE).toString();

        if (sensorType.equalsIgnoreCase(TemperatureSensor.class.getSimpleName())) {
            TemperatureSensorFactory temperatureSensorFactory = new TemperatureSensorFactory();
            sensor = temperatureSensorFactory.CreateTemperatureSensor(jsonObject);
        } else if (sensorType.equalsIgnoreCase(LightSensor.class.getSimpleName())) {
            LightSensorFactory lightSensorFactory = new LightSensorFactory();
            sensor = lightSensorFactory.CreateLightSensor(jsonObject);
        }

        return sensor;
    }
}

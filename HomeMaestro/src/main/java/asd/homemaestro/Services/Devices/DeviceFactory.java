package asd.homemaestro.Services.Devices;

import asd.Utils.ActuatorType;
import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.Utils.SensorType;
import asd.homemaestro.Entities.Devices.Actuators.AcActuator;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.Actuators.Tv;
import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.DeviceCollection;

import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Devices.Sensors.TemperatureSensor;
import asd.virtualdevices.Services.Factories.SensorFactory;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DeviceFactory {

    public static Sensor CreateSensor(JSONObject jsonObject){
        Sensor sensor = null;
        Gson gson = new Gson();
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(SensorType.Temperature.name())){
            sensor = gson.fromJson(jsonObject.toString(), TemperatureSensor.class);
        }
        return sensor;
    }

    public static Actuator CreateActuator(JSONObject jsonObject){
        Actuator actuator = null;
        Gson gson = new Gson();
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(ActuatorType.AC.name())){
            actuator = gson.fromJson(jsonObject.toString(), AcActuator.class);
        }
        return actuator;
    }
}

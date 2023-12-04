package asd.homemaestro.Services.Devices.Sensors;

import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import org.json.JSONObject;

public interface ISensorFactory{
    Sensor createSensorFromJson(JSONObject jsonObject);
}

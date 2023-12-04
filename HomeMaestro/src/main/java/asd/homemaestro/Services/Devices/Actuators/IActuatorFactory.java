package asd.homemaestro.Services.Devices.Actuators;

import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import org.json.JSONObject;

public interface IActuatorFactory {
    Actuator CreateActuatorFromJson(JSONObject jsonObject);
}

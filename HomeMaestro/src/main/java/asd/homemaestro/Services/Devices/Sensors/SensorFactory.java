package asd.homemaestro.Services.Devices.Sensors;

import asd.Utils.Consts;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.DataAccess.Rooms.RoomRepository;
import asd.homemaestro.DataAccess.Triggers.TriggerRepository;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Entities.Devices.Sensors.TemperatureSensor;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Entities.Triggers.Trigger;
import com.google.gson.Gson;
import org.json.JSONObject;
import asd.homemaestro.Entities.Devices.Sensors.LightSensor;


import java.util.List;

public class SensorFactory implements ISensorFactory{

    private final IRepository<Trigger> triggerRepository;

    public SensorFactory() {
        this.triggerRepository = new TriggerRepository();
    }


    @Override
    public Sensor createSensorFromJson(JSONObject jsonObject) {
        Sensor sensor = null;
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(TemperatureSensor.class.getSimpleName())){
            TemperatureSensorFactory temperatureSensorFactory = new TemperatureSensorFactory();
            sensor = temperatureSensorFactory.CreateTemperatureSensor(jsonObject);
        }
        List<Trigger> triggers = triggerRepository.getElementsById(sensor.getId());
        if(!triggers.isEmpty())
            sensor.setTriggerList(triggers);
        return sensor;
    }
}

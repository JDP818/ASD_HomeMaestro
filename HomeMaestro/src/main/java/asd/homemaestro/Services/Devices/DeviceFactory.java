package asd.homemaestro.Services.Devices;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.IDevice;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Services.Devices.Actuators.ActuatorFactory;
import asd.homemaestro.Services.Devices.Actuators.IActuatorFactory;
import asd.homemaestro.Services.Devices.Sensors.ISensorFactory;
import asd.homemaestro.Services.Devices.Sensors.SensorFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeviceFactory implements IDeviceFactory{
    private ISensorFactory sensorFactory;
    private IActuatorFactory actuatorFactory;

    public DeviceFactory() {
        this.sensorFactory = new SensorFactory();
        this.actuatorFactory = new ActuatorFactory();
    }

    @Override
    public Device createDevice(String id, String name, String state) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Device createDeviceFromJson(JSONObject jsonObject) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IDevice createDeviceListFromJson(JSONArray jsonArray, String roomId) {
        DeviceCollection deviceCollection = new DeviceCollection();
        for(int i = 0; i < jsonArray.length(); i++){
            var jsonObject = jsonArray.getJSONObject(i);
            if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(Sensor.class.getSimpleName())
                    && jsonObject.get(Consts.JSONROOMID).toString().equalsIgnoreCase(roomId)){
                Sensor sensor = sensorFactory.createSensorFromJson(jsonObject);
                if(sensor != null)
                    deviceCollection.addDevice(sensor);
            }else if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(Actuator.class.getSimpleName())
                    && jsonObject.get(Consts.JSONROOMID).toString().equalsIgnoreCase(roomId)){
                Actuator actuator = actuatorFactory.CreateActuatorFromJson(jsonObject);
                if(actuator != null)
                    deviceCollection.addDevice(actuator);
            }
        }
        return deviceCollection;
    }
}

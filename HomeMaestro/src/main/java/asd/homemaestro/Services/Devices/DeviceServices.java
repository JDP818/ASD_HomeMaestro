package asd.homemaestro.Services.Devices;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DeviceServices {
    public static List<DeviceCollection> GetDeviceList(String roomId){
        List<DeviceCollection> deviceList = new ArrayList<>();
        DeviceCollection sensorList = new DeviceCollection();
        DeviceCollection actuatorList = new DeviceCollection();
        JSONArray sensorJson = JsonReader.ReadJson(Consts.DEVICES_FILE_NAME);
        for(int i = 0; i < sensorJson.length(); i++){
            var jsonObject = sensorJson.getJSONObject(i);
            if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(Sensor.class.getSimpleName())
                && jsonObject.get(Consts.JSONROOMID).toString().equalsIgnoreCase(roomId)){
                Sensor sensor = DeviceFactory.CreateSensor(jsonObject);
                if(sensor != null)
                    sensorList.addDevice(sensor);
            }else if(jsonObject.get(Consts.JSONDEVICETYPE).toString().equalsIgnoreCase(Actuator.class.getSimpleName())
                && jsonObject.get(Consts.JSONROOMID).toString().equalsIgnoreCase(roomId)){
                Actuator actuator = DeviceFactory.CreateActuator(jsonObject);
                if(actuator != null)
                    actuatorList.addDevice(actuator);
            }
        }
        deviceList.add(sensorList);
        deviceList.add(actuatorList);
        return deviceList;
    }
}

package asd.homemaestro.DataAccess.Devices;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Services.Devices.DeviceFactory;
import asd.homemaestro.Services.Devices.IDeviceFactory;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepository {

    private IDeviceFactory deviceFactory;

    public DeviceRepository() {
        this.deviceFactory = new DeviceFactory();
    }

    public DeviceCollection GetDevicesForRoom(String roomId){
        JSONArray jsonArray= JsonReader.ReadJson(Consts.DEVICES_FILE_NAME);
        DeviceCollection deviceCollection = null;
        deviceCollection = (DeviceCollection)deviceFactory.createDeviceListFromJson(jsonArray, roomId);
        return deviceCollection;
    }
}

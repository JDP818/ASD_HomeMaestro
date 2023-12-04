package asd.homemaestro.DataAccess.Devices;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Devices.Sensors.Sensor;
import asd.homemaestro.Services.Devices.DeviceFactory;
import asd.homemaestro.Services.Devices.IDeviceFactory;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DeviceRepository implements IRepository<DeviceCollection> {

    private IDeviceFactory deviceFactory;

    public DeviceRepository() {
        this.deviceFactory = new DeviceFactory();
    }

    @Override
    public DeviceCollection getElement() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<DeviceCollection> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public DeviceCollection getElementById(String id) {
        JSONArray jsonArray= JsonReader.ReadJson(Consts.DEVICES_FILE_NAME);
        DeviceCollection deviceCollection = null;
        deviceCollection = (DeviceCollection)deviceFactory.createDeviceListFromJson(jsonArray, id);
        return deviceCollection;
    }

    @Override
    public List<DeviceCollection> getElementsById(String id) {
        throw new UnsupportedOperationException();
    }
}

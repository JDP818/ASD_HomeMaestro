package asd.homemaestro.Services.Devices;

import asd.homemaestro.Entities.Devices.Device;
import asd.homemaestro.Entities.Devices.IDevice;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IDeviceFactory {
    Device createDevice(String id, String name, String state);
    Device createDeviceFromJson(JSONObject jsonObject);
    IDevice createDeviceListFromJson(JSONArray jsonArray, String roomId);
}

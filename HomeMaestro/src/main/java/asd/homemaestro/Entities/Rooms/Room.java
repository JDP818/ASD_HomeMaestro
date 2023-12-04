package asd.homemaestro.Entities.Rooms;

import asd.homemaestro.Entities.Devices.DeviceCollection;

import java.util.List;

public class Room {

    private String Id;
    private String Name;
    private DeviceCollection DeviceGroups;

    public Room() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public DeviceCollection getDeviceGroups() {
        return DeviceGroups;
    }

    public void setDeviceGroups(DeviceCollection deviceGroups) {
        DeviceGroups = deviceGroups;
    }
}

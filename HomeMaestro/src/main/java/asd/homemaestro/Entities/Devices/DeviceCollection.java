package asd.homemaestro.Entities.Devices;

import java.util.ArrayList;
import java.util.List;

public class DeviceCollection implements IDevice{
    private List<IDevice> deviceList = new ArrayList<IDevice>();

    public void addDevice(Device device)
    {
        deviceList.add(device);
    }

    public void removeDevice(Device device)
    {
        deviceList.remove(device);
    }

    public List<IDevice> getDeviceLeaves() {
        List<IDevice> devices = new ArrayList<>();
        for (IDevice device : deviceList) {
            if (device instanceof DeviceCollection) {
                devices.addAll(((DeviceCollection) device).getDeviceLeaves());
            } else {
                devices.add(device);
            }
        }
        return deviceList;
    }

    public void setDeviceList(List<IDevice> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public void setState(String state) {
        for (IDevice device:deviceList) {
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        for (IDevice device:deviceList) {
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getState() {
        for (IDevice device:deviceList) {
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String getId() {
        for (IDevice device:deviceList) {
        }
        throw new UnsupportedOperationException();
    }
}

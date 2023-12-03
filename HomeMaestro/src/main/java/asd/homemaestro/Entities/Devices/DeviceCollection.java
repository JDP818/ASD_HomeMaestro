package asd.homemaestro.Entities.Devices;

import java.util.ArrayList;
import java.util.List;

public class DeviceCollection implements IDevice{
    private List<Device> deviceList = new ArrayList<Device>();

    public void addDevice(Device device)
    {
        deviceList.add(device);
    }

    public void removeDevice(Device device)
    {
        deviceList.remove(device);
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    @Override
    public void turnOn() {
        for (Device device:deviceList) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void turnOff() {
        for (Device device:deviceList) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void getInfo() {
        for (Device device:deviceList) {
            throw new UnsupportedOperationException();
        }
    }
}

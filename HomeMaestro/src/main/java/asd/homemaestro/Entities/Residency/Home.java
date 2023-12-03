package asd.homemaestro.Entities.Residency;

import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Entities.Triggers.TriggerType;

import java.util.ArrayList;
import java.util.List;

public class Home {
    private String Id;
    private String Name;
    private String PhoneNumber;
    private String Address;
    private List<Room> Rooms = new ArrayList<Room>();
    //private List<Trigger> Triggers = new ArrayList<Trigger>();

    public Home(){

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

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public List<Room> getRooms() {
        return Rooms;
    }

    public void setRooms(List<Room> rooms) {
        Rooms = rooms;
    }
}

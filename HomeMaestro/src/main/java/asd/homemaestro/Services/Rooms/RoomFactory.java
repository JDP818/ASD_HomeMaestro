package asd.homemaestro.Services.Rooms;

import asd.homemaestro.DataAccess.Devices.DeviceRepository;
import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Entities.Rooms.Room;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {
    private final DeviceRepository deviceRepository;

    public RoomFactory() {
        this.deviceRepository = new DeviceRepository();
    }

    public List<Room> CreateRooms(JSONArray roomArray, Boolean getDevices){
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < roomArray.length(); i++){
            var jsonObject = roomArray.getJSONObject(i);
            Room room = CreateRoomFromJsonObject(jsonObject);
            if(getDevices){
                DeviceCollection deviceCollection = deviceRepository.GetDevicesForRoom(room.getId());
                if(deviceCollection != null)
                    room.setDeviceGroups(deviceCollection);
            }
            rooms.add(room);
        }
        return rooms;
    }

    private Room CreateRoomFromJsonObject(JSONObject jsonObject){
        Home home = null;
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.toString(), Room.class);
    }
}

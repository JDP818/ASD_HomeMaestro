package asd.homemaestro.Services.Rooms;

import asd.homemaestro.Entities.Devices.DeviceCollection;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Services.Devices.DeviceServices;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoomFactory {

    public static List<Room> CreateRooms(JSONArray roomArray){
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < roomArray.length(); i++){
            var jsonObject = roomArray.getJSONObject(i);
            Room room = CreateRoomFromJsonObject(jsonObject);
            rooms.add(room);
        }
        return rooms;
    }

    public static List<Room> CreateRooms(JSONArray roomArray, Boolean getDevices){
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < roomArray.length(); i++){
            var jsonObject = roomArray.getJSONObject(i);
            Room room = CreateRoomFromJsonObject(jsonObject);
            if(getDevices){
                List<DeviceCollection> devices = DeviceServices.GetDeviceList(room.getId());
                room.setDeviceGroups(devices);
            }
            rooms.add(room);
        }
        return rooms;
    }

    private static Room CreateRoomFromJsonObject(JSONObject jsonObject){
        Home home = null;
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.toString(), Room.class);
    }
}

package asd.homemaestro.Services.Rooms;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Rooms.Room;
import org.json.JSONArray;

import java.util.List;

public class RoomServices {
    public static List<Room> getRooms(){
        JSONArray roomsJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return RoomFactory.CreateRooms(roomsJson);
    }

    public static List<Room> getRooms(Boolean getDevices){
        JSONArray roomsJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return RoomFactory.CreateRooms(roomsJson, getDevices);
    }

    public static void addHome(){
        throw new UnsupportedOperationException();
    }

    public static void updateHome(){
        throw new UnsupportedOperationException();
    }
}

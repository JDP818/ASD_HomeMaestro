package asd.homemaestro.DataAccess.Rooms;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Services.Residency.HomeFactory;
import asd.homemaestro.Services.Rooms.RoomFactory;
import org.json.JSONArray;

import java.util.List;

public class RoomRepository {
    private RoomFactory roomFactory;

    public RoomRepository() {
        this.roomFactory = new RoomFactory();
    }

    public List<Room> getRooms(Boolean getDevices){
        JSONArray roomsJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return roomFactory.CreateRooms(roomsJson, getDevices);
    }
}

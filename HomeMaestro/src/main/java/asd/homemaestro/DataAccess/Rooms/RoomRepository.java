package asd.homemaestro.DataAccess.Rooms;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.Entities.Rooms.Room;
import asd.homemaestro.Services.Residency.HomeFactory;
import asd.homemaestro.Services.Rooms.RoomFactory;
import org.json.JSONArray;

import java.util.List;

public class RoomRepository implements IRepository<Room> {
    private RoomFactory roomFactory;

    public RoomRepository() {
        this.roomFactory = new RoomFactory();
    }
    
    @Override
    public Room getElement() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Room> getElements() {
        JSONArray roomsJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return roomFactory.CreateRooms(roomsJson);
    }

    @Override
    public Room getElementById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Room> getElementsById(String id) {
        throw new UnsupportedOperationException();
    }
}

package asd.homemaestro.Services.Residency;

import asd.Utils.Consts;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.DataAccess.Rooms.RoomRepository;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Entities.Rooms.Room;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

public class HomeFactory {
    private final IRepository<Room> roomRepository;

    public HomeFactory() {
        this.roomRepository = new RoomRepository();
    }

    public Home CreateHome(JSONArray homeArray){
        if(homeArray.isEmpty()){
            //Throw exception
        }
        var jsonObject = homeArray.getJSONObject(Consts.FIRST);
        Home home = CreateHomeFromJsonObject(jsonObject);
        home.setRooms(roomRepository.getElements());
        return home;
    }

    private static Home CreateHomeFromJsonObject(JSONObject jsonObject){
        Gson gson = new Gson();
        return gson.fromJson(jsonObject.toString(), Home.class);
    }
}

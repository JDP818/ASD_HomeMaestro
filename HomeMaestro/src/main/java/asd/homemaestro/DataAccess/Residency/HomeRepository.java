package asd.homemaestro.DataAccess.Residency;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Services.Residency.HomeFactory;
import org.json.JSONArray;

public class HomeRepository {
    private HomeFactory homeFactory;

    public HomeRepository() {
        this.homeFactory = new HomeFactory();
    }

    public Home getHome(){
        JSONArray homeJson = JsonReader.ReadJson(Consts.HOME_FILE_NAME);
        Home home = null;
        if(!homeJson.isEmpty()){
            home = homeFactory.CreateHome(homeJson);
        }
        return home;
    }
}

package asd.homemaestro.DataAccess.Residency;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Services.Residency.HomeFactory;
import org.json.JSONArray;

import java.util.List;

public class HomeRepository implements IRepository<Home> {
    private HomeFactory homeFactory;

    public HomeRepository() {
        this.homeFactory = new HomeFactory();
    }

    @Override
    public Home getElement() {
        JSONArray homeJson = JsonReader.ReadJson(Consts.HOME_FILE_NAME);
        Home home = null;
        if(!homeJson.isEmpty()){
            home = homeFactory.CreateHome(homeJson);
        }
        return home;
    }

    @Override
    public List<Home> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Home getElementById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Home> getElementsById(String id) {
        throw new UnsupportedOperationException();
    }
}

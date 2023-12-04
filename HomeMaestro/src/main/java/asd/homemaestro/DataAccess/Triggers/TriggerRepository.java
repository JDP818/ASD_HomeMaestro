package asd.homemaestro.DataAccess.Triggers;

import asd.Utils.Consts;
import asd.Utils.JsonReader;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.Entities.Triggers.Trigger;
import asd.homemaestro.Services.Triggers.TriggerFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TriggerRepository implements IRepository<Trigger> {
    private TriggerFactory triggerFactory;

    public TriggerRepository() {
        this.triggerFactory = new TriggerFactory();
    }

    @Override
    public Trigger getElement() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Trigger> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Trigger getElementById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Trigger> getElementsById(String id) {
        JSONArray triggersJson = JsonReader.ReadJson(Consts.ROOMS_FILE_NAME);
        return triggerFactory.createTriggerListFromJson(triggersJson, id);
    }
}
package asd.homemaestro.Services.Devices.Actuators;

import asd.Utils.Consts;
import asd.homemaestro.Entities.Devices.Actuators.AcActuator;
import asd.homemaestro.Entities.Devices.Actuators.Actuator;
import asd.homemaestro.Entities.Devices.Actuators.BlindsActuator;

import org.json.JSONObject;

public class ActuatorFactory implements IActuatorFactory{

    @Override
    public Actuator CreateActuatorFromJson(JSONObject jsonObject) {
        Actuator actuator = null;
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(AcActuator.class.getSimpleName())){
            AcActuatorFactory acActuatorFactory = new AcActuatorFactory();
            actuator = acActuatorFactory.CreateAcActuator(jsonObject);
        }
        if(jsonObject.get(Consts.JSONTYPE).toString().equalsIgnoreCase(BlindsActuator.class.getSimpleName())){
            BlindsActuatorFactory blindsActuatorFactory = new BlindsActuatorFactory();
            actuator = blindsActuatorFactory.CreateBlindsActuator(jsonObject);
        }
        return actuator;
    }
}

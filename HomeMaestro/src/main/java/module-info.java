module asd.homemaestro {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.paho.client.mqttv3;
    requires org.json;
    requires com.google.gson;

    opens asd.virtualdevices.Entities to com.google.gson;
    opens asd.homemaestro.Entities.Residency to com.google.gson;
    opens asd.homemaestro.Entities.Rooms to com.google.gson;
    opens asd.homemaestro.Entities.Devices to com.google.gson;
    opens asd.homemaestro to javafx.fxml;
    exports asd.homemaestro;
    exports asd.virtualdevices;
    exports asd.homemaestro.Controllers;
    opens asd.homemaestro.Controllers to javafx.fxml;
    opens asd.Utils to com.google.gson;
}
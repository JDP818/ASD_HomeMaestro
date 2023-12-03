package asd.homemaestro;

import asd.Utils.Consts;
import asd.homemaestro.Controllers.HomeMaestroController;
import asd.homemaestro.Entities.Residency.Home;
import asd.homemaestro.Services.Residency.HomeFactory;
import asd.homemaestro.Services.Residency.HomeServices;
import asd.homemaestro.mosquitto.MqttPublisher;
import asd.homemaestro.mosquitto.MqttSubscriber;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeMaestroApplication extends Application {
    private HomeMaestroController homeMaestroController;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        setStartingScene();
        stage.setTitle("Home Maestro");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void setStartingScene() throws IOException {
        Home home = HomeServices.getHome();
        if (home == null){
            //return scene to set up home
        }else {
            CreateScene(Consts.HOMEMAESTRO_FXML);
            homeMaestroController = fxmlLoader.getController();
            homeMaestroController.setHome(home);
            homeMaestroController.addRooms();
        }
    }

    private void CreateScene(String fxmlFileName) throws IOException {
        fxmlLoader = new FXMLLoader(HomeMaestroApplication.class.getResource(fxmlFileName));
        scene = new Scene(fxmlLoader.load());
    }
}
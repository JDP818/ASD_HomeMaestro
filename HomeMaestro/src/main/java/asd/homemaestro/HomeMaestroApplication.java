package asd.homemaestro;

import asd.Utils.Consts;
import asd.homemaestro.Controllers.HomeMaestroController;
import asd.homemaestro.DataAccess.IRepository;
import asd.homemaestro.DataAccess.Residency.HomeRepository;
import asd.homemaestro.Entities.Residency.Home;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeMaestroApplication extends Application {
    private HomeMaestroController homeMaestroController;
    private FXMLLoader fxmlLoader;
    private Scene scene;
    private final IRepository<Home> homeRepository = new HomeRepository();;

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
        Home home = homeRepository.getElement();
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
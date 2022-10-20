package library.rent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import library.Main;

public class RentController {
    public void backToHome() throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Main.rootStage.setTitle("Menu");
        Main.rootStage.setScene(new Scene(menu,600,600));
    }


}

package assignment1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Controller {

    public void book() throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("list book");
        Main.rootStage.setScene(listScene);
    }
    public void member() throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("member/list/list.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("list member");
        Main.rootStage.setScene(listScene);
    }
    public void bookmember() throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("bookmember/list/list.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("list");
        Main.rootStage.setScene(listScene);
    }
}

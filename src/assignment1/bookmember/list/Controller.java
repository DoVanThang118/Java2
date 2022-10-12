package assignment1.bookmember.list;


import assignment1.bookmember.BookMember;
import assignment1.bookmember.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

import static assignment1.bookmember.form.Controller.list;


public class Controller implements Initializable {
    public ListView<BookMember> lv;

    public static BookMember editItem;

    public void goToForm(ActionEvent actionEvent) throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../form/form.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("add subject");
        Main.rootStage.setScene(listScene);
    }
    public void menu() throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../../assignment1.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        assignment1.Main.rootStage.setTitle("menu");
        assignment1.Main.rootStage.setScene(listScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        list.add(new Subject("asd","zxc",40));
//        list.add(new Subject("qweq","asd",50));
        lv.setItems(list);
    }

    public void edit(ActionEvent actionEvent) throws Exception {
        editItem = lv.getSelectionModel().getSelectedItem();
        if (editItem == null) return;

        Parent listPage = FXMLLoader.load(getClass().getResource("../edit/edit.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("edit subject");
        Main.rootStage.setScene(listScene);
    }
}

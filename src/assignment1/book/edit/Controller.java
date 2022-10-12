package assignment1.book.edit;

import assignment1.book.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

import static assignment1.book.list.Controller.editItem;


public class Controller implements Initializable {
    public Text errors;
    public TextField txtCode;
    public TextField txtName;
    public TextField txtHours;

    public void backToList() throws Exception {
        Parent listPage = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Scene listScene = new Scene(listPage,600,600);

        Main.rootStage.setTitle("list subject");
        Main.rootStage.setScene(listScene);
    }

    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (editItem == null){
                backToList();
            }
            txtCode.setText(editItem.getCode());
            txtName.setText(editItem.getName());
            txtHours.setText(editItem.getHours().toString());
            txtCode.setEditable(false);
        }catch (Exception e){
            errors.setText(e.getMessage());
            errors.setVisible(true);
        }
    }

    public void update(ActionEvent actionEvent) {
        try {
            errors.setVisible(false);
            int hours = Integer.parseInt(txtHours.getText());
            if(txtName.getText().isEmpty() || hours <= 0){
                throw new Exception("Vui lòng nhập các thông tin hợp lệ");
            }
            editItem.setName(txtName.getText());
            editItem.setHours(hours);
            backToList();
        }
        catch (Exception e){
            errors.setText(e.getMessage());
            errors.setVisible(true);
        }
    }
}

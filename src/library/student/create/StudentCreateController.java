package library.student.create;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.Main;
import library.helper.Connector;

import java.util.ArrayList;

public class StudentCreateController {

    public Text errors;

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;

    public void backToList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("List Student");
        Main.rootStage.setScene(new Scene(listBook,600,600));
    }
    public void addStudent() {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            int tel = Integer.parseInt(txtTel.getText());
            String sql_txt = "INSERT INTO student(name,email,tel) VALUES (?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(name);
            arr.add(email);
            arr.add(tel);
            if (connector.execute(sql_txt,arr)){
                backToList();
            }else {
                System.out.println("ERROR");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

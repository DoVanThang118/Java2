package assignment1.member.form;


import assignment1.member.Main;
import assignment1.member.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Controller {

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

    public static ObservableList<Member> listmember = FXCollections.observableArrayList();
    public void addSubject() {
        try {
            errors.setVisible(false);
            int hours = Integer.parseInt(txtHours.getText());
            if(txtCode.getText().isEmpty() || txtName.getText().isEmpty() || hours <= 0){
                throw new Exception("Vui lòng nhập các thông tin hợp lệ");
            }
            for (Member s: listmember){
                if (s.getCode().equals(txtCode.getText()))
                    throw new Exception("Vui lòng nhập các thông tin hợp lệ");
            }
            listmember.add(new Member(txtCode.getText(),txtName.getText(),hours));
            backToList();
        }
        catch (Exception e){
            errors.setText(e.getMessage());
            errors.setVisible(true);
        }
    }
}

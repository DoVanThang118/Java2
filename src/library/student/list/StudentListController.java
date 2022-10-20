package library.student.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Student;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdEmail;
    public TableColumn<Student,Integer> tdTel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tdTel.setCellValueFactory(new PropertyValueFactory<Student,Integer>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
//        ls.add(new Book(1,"asd","asd",12));
//        ls.add(new Book(2,"qwe","qwe",23));

        //lay database
        try {
            String sql_txt = "select * from student";
            Connector connector = Connector.getInstance();
            ResultSet resultSet = connector.query(sql_txt);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int tel = resultSet.getInt("tel");
                Student student = new Student(id,name,email,tel);
                ls.add(student);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(ls);
        }
    }

    public void backToHome() throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Menu");
        Main.rootStage.setScene(new Scene(menu,600,600));
    }

    public void addToStudent() throws Exception {
        Parent addStudent = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Add Student");
        Main.rootStage.setScene(new Scene(addStudent,600,600));
    }
}

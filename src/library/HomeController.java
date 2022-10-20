package library;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void goToBookList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Main.rootStage.setTitle("List Book");
        Main.rootStage.setScene(new Scene(listBook,600,600));
    }

    public void goToStudentList() throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("student/list/list.fxml"));
        Main.rootStage.setTitle("List Student");
        Main.rootStage.setScene(new Scene(listStudent,600,600));
    }
    public void goToStudentRent() throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("rent/rent.fxml"));
        Main.rootStage.setTitle("Rental Book");
        Main.rootStage.setScene(new Scene(listStudent,600,600));
    }
}

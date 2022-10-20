package library.rent.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.entities.Student;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RentController implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox<Student> cbStudent;
    public DatePicker dpExp;

    public void backToHome() throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Menu");
        Main.rootStage.setScene(new Scene(menu,600,600));
    }

    public void submit(ActionEvent actionEvent) {
        Book select = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpExp.getValue();
        System.out.println(select.getName());
        System.out.println(dp);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository bookRepository = new BookRepository();
        ObservableList<Book> list = FXCollections.observableArrayList();
        list.addAll(bookRepository.all());
        cbBook.setItems(list);
    }
}

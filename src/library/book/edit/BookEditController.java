package library.book.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BookEditController implements Initializable {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;
    public static Book editedBook;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedBook != null){
            txtName.setText(editedBook.getName());
            txtAuthor.setText(editedBook.getAuthor());
            txtQty.setText(editedBook.getQty().toString());
        }

    }

    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        library.Main.rootStage.setTitle("List Book");
        Main.rootStage.setScene(new Scene(listBook,600,600));
    }

    public void updateBook(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            editedBook.setName(name);
            editedBook.setAuthor(author);
            editedBook.setQty(qty);
            BookRepository rp = new BookRepository();
            if(rp.update(editedBook)){
                backToList(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book ?");
            alert.setHeaderText("Are you sure delete book: " + editedBook.getName() + "?");
            Optional<ButtonType> optional = alert.showAndWait();
            BookRepository bookRepository = new BookRepository();
            if (bookRepository.delete(editedBook)){
                backToList(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

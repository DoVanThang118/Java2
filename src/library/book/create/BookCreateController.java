package library.book.create;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.helper.Connector;

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class BookCreateController {

    public Text errors;

    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void backToList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        library.Main.rootStage.setTitle("List Book");
        Main.rootStage.setScene(new Scene(listBook,600,600));
    }
    public void addBook() {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            Book book = new Book(null,name,author,qty);
            BookRepository bookRepository = new BookRepository();
            if (bookRepository.create(book)){
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

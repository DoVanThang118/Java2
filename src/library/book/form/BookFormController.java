package library.book.form;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static library.book.list.BookListController.*;


public class BookFormController {

    public Text errors;

    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void backToList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        library.Main.rootStage.setTitle("List Book");
        Main.rootStage.setScene(new Scene(listBook,600,600));
    }
    public void addBook() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO 'books'('id','name','author','qty') " + "VALUES (null," + txtName.getText() + ", " + txtAuthor.getText() + ", " + txtQty.getText() + ")";
            statement.executeUpdate(sql);
        }
        catch(SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
        backToList();
    }
}

package library.book.list;

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
import library.entities.Book;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
//        ls.add(new Book(1,"asd","asd",12));
//        ls.add(new Book(2,"qwe","qwe",23));

        //lay database
        try {
            String sql_txt = "select * from books";
            Connector connector = Connector.getInstance();
            ResultSet resultSet = connector.query(sql_txt);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int qty = resultSet.getInt("qty");
                Book book = new Book(id,name,author,qty);
                ls.add(book);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbBooks.setItems(ls);
        }
    }

    public void backToHome() throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Menu");
        Main.rootStage.setScene(new Scene(menu,600,600));
    }

    public void addToBook() throws Exception {
        Parent addBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Add Book");
        Main.rootStage.setScene(new Scene(addBook,600,600));
    }
}

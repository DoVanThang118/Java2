package library.book.create;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.Main;
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
    public void addBook() throws Exception {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            int qty = Integer.parseInt(txtQty.getText());
            String sql_txt = "INSERT INTO books(name,author,qty) VALUES (?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(name);
            arrayList.add(author);
            arrayList.add(qty);
            if (connector.execute(sql_txt,arrayList)){
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
